package com.ecovacs.adminmgr.easyrule;

import org.example.entity.Order;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;

/**
 * @author walker.dou
 */
public class EasyRuleDemo {
    public static void main(String[] args) {
        //规则引擎
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
//        rulesEngine.registerRuleListener(new CustomRuleListener());
//        rulesEngine.registerRulesEngineListener(new CustomRulesEngineListener());

        MVELRule ageRule = new MVELRule()
                .name("easyRule name")
                .description("easyRule desc")
                .priority(1)
                .when("order.status == \"已完成\"")
                .then("order.ship();");

        Rules rules = new Rules();
//        rules.register(new MyRule());
        rules.register(ageRule);

        Facts facts = new Facts();

        Order order = new Order();
        order.setOrderNo("easyRule 测试单号");
        order.setStatus("已完成");
        facts.put("order", order);

        rulesEngine.fire(rules, facts);

    }

}
