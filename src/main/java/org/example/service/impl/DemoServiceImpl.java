package org.example.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author walker.dou
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Override
    public void print() {
        System.out.println("123");

    }

    @Override
    public User findOne(String name) {
        return User.userList.stream().filter(user -> Objects.equals(user.getName(), name)).findFirst().orElse(null);

    }
}
