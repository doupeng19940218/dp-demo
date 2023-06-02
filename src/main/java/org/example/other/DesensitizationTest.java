package org.example.other;

import org.example.entity.User;
import red.zyc.desensitization.Sensitive;

/**
 * @author walker.dou
 */
public class DesensitizationTest {
    public static void main(String[] args) {
        final User user = new User();
        user.setName("dp");
        user.setPhone("18036094790");
        final User desensitize = Sensitive.desensitize(user);
        System.out.println(desensitize);
    }
}
