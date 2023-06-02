package org.example.service;

import org.example.entity.User;

/**
 * @author walker.dou
 */
public interface DemoService {


    void print();

    User findOne(String name);
}
