package org.example.rule.aviator;

import com.alibaba.fastjson.JSON;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.example.entity.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author walker.dou
 */
public class AviatorDemo {
    public static void main(String[] args) {
        AviatorEvaluator.addFunction(new UserDefinedFunction());
        String expression = "if (order.status == \"已完成\"){ship(order)}";
        Order order = new Order();
        order.setOrderNo("Aviator 测试单号");
        order.setStatus("已完成");
        Map<String, Object> env = new HashMap<>();
        env.put("order", JSON.parseObject(JSON.toJSONString(order)));
        AviatorEvaluator.execute(expression, env);

    }
}

class UserDefinedFunction extends AbstractFunction {
    //自定义功能的名字
    @Override
    public String getName() {
        return "ship";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        JSON.parseObject(JSON.toJSONString(env.get(((AviatorJavaType) arg1).getName())), Order.class).ship();
        return arg1;
    }
}
