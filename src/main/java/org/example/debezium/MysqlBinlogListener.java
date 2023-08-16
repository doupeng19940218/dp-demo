package org.example.debezium;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.config.Configuration;
import io.debezium.data.Envelope;
import io.debezium.engine.ChangeEvent;
import io.debezium.engine.DebeziumEngine;
import io.debezium.engine.format.Json;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * @projectName: test
 * @package: com.test.config
 * @className: MysqlBinlogListener
 * @author: nyp
 * @date: 2023/8/7 13:56
 * @version: 1.0
 */
//@Component
@Slf4j
public class MysqlBinlogListener {

    @Resource
    private Executor taskExecutor;
    @Autowired
    private ObjectMapper objectMapper;

    private final List<DebeziumEngine<ChangeEvent<String, String>>> engineList = new ArrayList<>();

    public MysqlBinlogListener (Configuration configuration) {
        this.engineList.add(DebeziumEngine.create(Json.class)
                .using(configuration.asProperties())
                .notifying(record -> receiveChangeEvent(record.value()))
                .build());
    }

    private void receiveChangeEvent(String value) {
        if (Objects.nonNull(value)) {
            Map<String, Object> payload = getPayload(value);
            String op = JSON.parseObject(JSON.toJSONString(payload.get("op")), String.class);
            if (!(StringUtils.isBlank(op) || Envelope.Operation.READ.equals(op))) {
                ChangeData changeData = getChangeData(payload);
                // 这里抛出异常会导致后面的日志监听失败
                try {
                    System.out.println(objectMapper.writeValueAsString(changeData));
                }catch (Exception e){
                    log.error("binlog处理异常，原数据: " + changeData, e);
                }

            }
        }
    }

    @PostConstruct
    private void start() {
        for (DebeziumEngine<ChangeEvent<String, String>> engine : engineList) {
            taskExecutor.execute(engine);
        }
    }

    @PreDestroy
    private void stop() {
        for (DebeziumEngine<ChangeEvent<String, String>> engine : engineList) {
            if (engine != null) {
                try {
                    engine.close();
                } catch (IOException e) {
                    log.error("", e);
                }
            }
        }
    }


    public static Map<String, Object> getPayload(String value) {
        Map<String, Object> map = JSON.parseObject(value, Map.class);
        Map<String, Object> payload = JSON.parseObject(JSON.toJSONString(map.get("payload")), Map.class);
        return payload;
    }

    public static ChangeData getChangeData(Map<String, Object> payload) {
        Map<String, Object> source = JSON.parseObject(JSON.toJSONString(payload.get("source")), Map.class);
        return ChangeData.builder()
                .op(payload.get("op").toString())
                .table(source.get("table").toString())
                .after(JSON.parseObject(JSON.toJSONString(payload.get("after")), Map.class))
                .source(JSON.parseObject(JSON.toJSONString(payload.get("source")), Map.class))
                .before(JSON.parseObject(JSON.toJSONString(payload.get("before")), Map.class))
                .build();
    }

    @Data
    @Builder
    public static class ChangeData {
        /**
         * 更改前数据
         */
        private Map<String, Object> after;
        private Map<String, Object> source;
        /**
         * 更改后数据
         */
        private Map<String, Object> before;
        /**
         * 更改的表名
         */
        private String table;
        /**
         * 操作类型, 枚举 Envelope.Operation
         */
        private String op;
    }

}
