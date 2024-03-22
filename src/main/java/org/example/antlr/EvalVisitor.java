package org.example.antlr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author walker.dou
 */
public class EvalVisitor  extends ArithmeticBaseVisitor<Double> {
    // 使用一个Map来存储变量名和值的映射关系
    Map<String, Double> memory = new HashMap<String, Double>();


    // 重写visitExpr方法，用于计算加法和减法
    @Override
    public Double visitExpr(ArithmeticParser.ExprContext ctx) {
        Double result = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            String op = ctx.getChild(2*i - 1).getText();
            Double term = visit(ctx.term(i));
            if (op.equals("+")) {
                result += term;
            } else {
                result -= term;
            }
        }
        return result;
    }

    // 重写visitTerm方法，用于计算乘法和除法
    @Override
    public Double visitTerm(ArithmeticParser.TermContext ctx) {
        Double result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.getChild(2*i - 1).getText();
            Double factor = visit(ctx.factor(i));
            if (op.equals("*")) {
                result *= factor;
            } else {
                result /= factor;
            }
        }
        return result;
    }

    // 重写visitFactor方法，用于计算数字和括号内的表达式
    @Override
    public Double visitFactor(ArithmeticParser.FactorContext ctx) {
        if (ctx.NUMBER() != null) {
            // 如果是一个数字，直接返回其值
            return Double.parseDouble(ctx.NUMBER().getText());
        } else {
            // 如果是括号内的表达式，递归调用visit方法
            return visit(ctx.expr());
        }
    }
}

