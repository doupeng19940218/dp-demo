package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker.dou
 */
@RestController
@RequestMapping("/api")
public class ApiController {


    @RequestMapping("/orderVender/addComment")
    public String jdAddComment(){
        return "{\n" +
                "  \"code\": \"0000\",\n" +
                "  \"msg\": \"操作成功\",\n" +
                "  \"time\": 1716945756416,\n" +
                "  \"success\": true\n" +
                "}";
    }

    @RequestMapping("/order/ksAddComment")
    public String ksAddComment(){
        return "{\n" +
                "  \"code\": \"0000\",\n" +
                "  \"msg\": \"操作成功\",\n" +
                "  \"time\": 1716945756416,\n" +
                "  \"success\": true\n" +
                "}";
    }

}
