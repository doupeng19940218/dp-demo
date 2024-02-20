package org.example.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author walker.dou
 */
public interface AsyncServiceInterface {
    @Async
    void print();

    void test();
}
