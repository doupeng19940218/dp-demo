package org.example.antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @author walker.dou
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String input = "1+1";
        // 创建一个词法分析器，用于将输入转换为标记
        ArithmeticLexer lexer = new ArithmeticLexer(CharStreams.fromString(input));

        // 创建一个标记流，用于将标记传递给解析
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 创建一个解析器，用于将标记转换为AST
        ArithmeticParser parser = new ArithmeticParser(tokens);

        // 调用解析器的parse方法，生成AST
        ParseTree tree = parser.parse();

        // 创建一个AST遍历器，用于计算表达式的值
        EvalVisitor eval = new EvalVisitor();

        // 遍历AST，并计算表达式的值
        Double result = eval.visit(tree);

        // 打印计算结果
        System.out.println(result);
    }

}
