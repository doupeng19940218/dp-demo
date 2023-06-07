//package org.example.rule.drools;
//
//import org.example.entity.Order;
//import org.kie.api.KieBase;
//import org.kie.api.io.ResourceType;
//import org.kie.api.runtime.KieSession;
//import org.kie.internal.utils.KieHelper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author walker.dou
// */
//@RestController
//@RequestMapping("/drools")
//public class DroolsDemo {
//    @Autowired
//    private KieSession session;
//
//    @Autowired
//    private KieBase kieBase;
//
//    @GetMapping("/test")
//    public void test(String[] args) {
//        Order order = new Order();
//        order.setOrderNo("drools 方式1 测试单号");
//        order.setStatus("已完成");
//        session.insert(order);//插入
//        session.fireAllRules();//执行规则
//    }
//
//    @GetMapping("/test2")
//    public void test2(String[] args) {
//        String rule = "package com.ecovacs.adminmgr.drools\n" +
//                "import com.ecovacs.adminmgr.Order\n" +
//                "dialect  \"java\"\n" +
//                "\n" +
//                "rule \"man\"\n" +
//                "    when\n" +
//                "        $p : Order(status == \"已完成\")\n" +
//                "    then\n" +
//                "        $p.ship();\n" +
//                "\n" +
//                "end";
//
//
//        KieHelper helper = new KieHelper();
//        helper.addContent(rule, ResourceType.DRL);
//        KieSession ksession = helper.build().newKieSession();
//        Order order = new Order();
//        order.setOrderNo("drools 方式2 测试单号");
//        order.setStatus("已完成");
//        ksession.insert(order);
//        ksession.fireAllRules();
//        ksession.dispose();
//    }
//
//
//}
