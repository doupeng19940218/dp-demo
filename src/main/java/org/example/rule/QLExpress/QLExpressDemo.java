package org.example.rule.QLExpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import lombok.SneakyThrows;
import org.example.entity.Order;

/**
 * @author walker.dou
 */
public class QLExpressDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ExpressRunner runner = new ExpressRunner();
        Order order = new Order();
        order.setOrderNo("QLExpress 测试单号");
        order.setStatus("已完成");
        runner.addFunctionOfServiceMethod("ship", order, "ship", new Class[]{}, null);
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("order", order);
        String express = "if (order.status == \"已完成\") {order.ship() }";
        runner.execute(express, context, null, true, false);
    }
}
