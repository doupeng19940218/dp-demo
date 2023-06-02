package org.example.controller.rest;

import lombok.val;
import org.example.entity.User;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker.dou
 */
@RequestMapping("user")
@RestController
public class UserController {

    @GetMapping
    public ResponseEntity<User> user(@RequestParam String name) {
        val user = new User();
        user.setName(name);
        user.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserController.class).user(name)).withSelfRel());
        return ResponseEntity.ok(user);
    }
}
