package org.example.spock


import org.example.DemoApplication
import org.example.service.DemoService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.annotation.Resource

/**
 * @author walker.dou
 */
@SpringBootTest(classes = DemoApplication.class)
//@ActiveProfiles("dev")
class SpringbootSpock extends Specification {

    @Resource
    DemoService demoService

    def demo() {

        when:
        def user = demoService.findOne(name)

        then:
        user != null

        where: "用户"
        name  | a
        "DP"  | 2
        "DP2" | 2

    }

}