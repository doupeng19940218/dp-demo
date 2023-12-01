package org.example.aviator;

import com.googlecode.aviator.AviatorEvaluator;

/**
 * @author walker.dou
 */
public class AviatorTest {
    public static void main(String[] args) {
        // 定义表达式
        String expression = "2 + 3 * (4 - 1)";

        // 使用Aviator计算表达式
        Object result = AviatorEvaluator.execute(expression);

        // 输出结果
        System.out.println("Result: " + result);
    }

}
