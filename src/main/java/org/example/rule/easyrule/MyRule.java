package com.ecovacs.adminmgr.easyrule;

import org.example.entity.Order;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.Objects;

/**
 * @author walker.dou
 */
@Rule(name = "my rule", description = "my rule description", priority = 1)
public class MyRule {

    @Condition
    public boolean when(@Fact("order") Order order) {
        // 规则条件
        return Objects.equals(order.getStatus(), "已完成");
    }

    @Action(order = 1)
    public void then(@Fact("order") Order order) throws Exception {
    }

    @Action(order = 2)
    public void end(@Fact("order") Order order) throws Exception {
        order.ship();
    }
}

