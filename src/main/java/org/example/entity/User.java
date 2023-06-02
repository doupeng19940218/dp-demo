package org.example.entity;

/**
 * @author walker.dou
 */

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.hateoas.ResourceSupport;
import red.zyc.desensitization.annotation.PhoneNumberSensitive;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends ResourceSupport {


    String name;

    @PhoneNumberSensitive
    String phone;

    public static User instance(){
        final User user = new User();
        user.setName("dp");
        user.setPhone("18036094790");
        return user;
    }

    public static List<User> userList = new ArrayList<>();
    static {
        final User user = new User();
        user.setName("DP");
        userList.add(user);
    }
}
