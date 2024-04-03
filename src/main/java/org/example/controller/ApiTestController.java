package org.example.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author walker.dou
 */
@RestController
@RequestMapping("/api/test")
public class ApiTestController {
    @RequestMapping("jitxSendBackWarehouse")
    @ResponseBody
    public Object jitxSendBackWarehouse() {
        final HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("code", "0000");
        objectObjectHashMap.put("meg", "操作成功");
        return objectObjectHashMap;
    }
}
