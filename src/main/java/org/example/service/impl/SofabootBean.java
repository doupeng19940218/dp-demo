package org.example.service.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author walker.dou
 */

@Slf4j
public class SofabootBean {


    @SneakyThrows
    public void init() {
        log.info("SofabootBean init start");
        TimeUnit.SECONDS.sleep(10L);
        log.info("SofabootBean init finish");
    }

}
