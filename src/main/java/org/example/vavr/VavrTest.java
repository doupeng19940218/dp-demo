package org.example.vavr;

import io.vavr.Function0;
import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.var;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Tuple2;

/**
 * @author walker.dou
 */
public class VavrTest {

    @Test
    public void test() {
        var tup = Tuple.of("hello", 1);
        // 模式匹配
        Match(tup).of(Case($Tuple2($("hello"), $(1)), (t1, t2) -> run(() -> {
            System.out.println(t1 + t2);
        })), Case($Tuple2($(), $()), (t1, t2) -> run(() -> {
            System.out.println(t1 + t2);
        })));
    }

    @Test
    public void testOption() {
        List<String> result = Option.of("vavr hello world")
                .map(String::toUpperCase)
                .toJavaList();
        System.out.println(result);

        // exists(Function)
        boolean exists = Option.of("ok").exists(str -> str.equals("ok"));
        System.out.println(exists);

        // contains
        boolean contains = Option.of("ok").contains("ok");
        System.out.println(contains);

    }

    @Test
    public void testTry() {

        Try.of(() -> 1 / 0)
                .andThen(r -> System.out.println("and then " + r))
                .onFailure(error -> System.out.println("failure" + error.getMessage()))
                .andFinally(() -> {
                    System.out.println("finally");
                });
    }

    @Test
    public void testLazy() {

        Lazy<Double> lazy = Lazy.of(Math::random);
        lazy.isEvaluated(); // = false
        lazy.get();         // = 0.123 (random generated)
        lazy.isEvaluated(); // = true
        lazy.get();         // = 0.123 (memoized)
    }

    @Test
    public void testMemorize() {
        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();

        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();

        System.out.println(randomValue1 == randomValue2);
    }

    @Test
    public void testClass() {
        final Demo3 demo3 = new Demo3();
        Demo a = (Demo & Demo2) demo3;
    }

    public static interface Demo {

    }

    public static interface Demo2 {

    }
    public static class Demo3 implements Demo, Demo2{

    }
}
