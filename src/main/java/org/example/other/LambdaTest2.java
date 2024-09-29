package org.example.other;

import java.lang.reflect.ParameterizedType;

/**
 * @author walker.dou
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        final Lambda<Double> lambda = new Lambda<Double>() {
            @Override
            public Double test() {
                return 1.1;
            }
        };

    }
}
