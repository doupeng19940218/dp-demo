package org.example.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.service.AsyncServiceInterface;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author walker.dou
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AsyncService implements AsyncServiceInterface {

    @Async
    @Override
    public void print(){
        System.out.println(String.format("thread name: %s working", Thread.currentThread().getName()));
    }

    @Override
    public void test() {

    }
}
