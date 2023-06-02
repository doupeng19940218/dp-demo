package org.example.type;


import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.AnnotatedTypeVariable;
import java.util.Arrays;

/**
 * @author zyc
 */
public class AnnotatedTypeVariableTest<T extends @AnnotatedTypeVariableTest.MyAnnotation(1) Number & @AnnotatedTypeVariableTest.MyAnnotation(2) Cloneable & @AnnotatedTypeVariableTest.MyAnnotation(3) Serializable> {

    public T t;

    public static void main(String[] args) throws Exception {
        AnnotatedTypeVariable annotatedTypeVariable = (AnnotatedTypeVariable) AnnotatedTypeVariableTest.class.getDeclaredField("t").getAnnotatedType();
        Arrays.stream(annotatedTypeVariable.getAnnotatedBounds()).forEach(annotatedType -> System.out.println(Arrays.toString(annotatedType.getDeclaredAnnotations())));
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface MyAnnotation {

        int value();
    }
}
