package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker.dou
 */
@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping
    public Result json() {
        final Person person = new Person();
        person.setName("parent1");
        final Person parent2 = new Person();
        parent2.setName("parent2");
        person.setParent(parent2);
        parent2.setParent(person);
        return Result.success(person);
    }

    @Getter
    @Setter
    public static class Person {
        String name;
        Person parent;
    }

}
