package org.example.type;


import java.lang.annotation.*;
import java.lang.reflect.AnnotatedParameterizedType;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyc
 */
public class AnnotatedParameterizedTypeTest {

//    public List<@MyAnnotation(1) String> list1;

    public List<@MyAnnotation(2) List<@MyAnnotation(3) String>> list2;

    public static void main(String[] args) {
        Arrays.stream(AnnotatedParameterizedTypeTest.class.getDeclaredFields()).forEach(field -> print((AnnotatedParameterizedType) field.getAnnotatedType()));
    }

    private static void print(AnnotatedParameterizedType annotatedParameterizedType) {
        Arrays.stream(annotatedParameterizedType.getAnnotatedActualTypeArguments())
                .forEach(annotatedType -> {
                            System.out.println(Arrays.toString(annotatedType.getDeclaredAnnotations()));
                            if (annotatedType instanceof AnnotatedParameterizedType) {
                                print((AnnotatedParameterizedType) annotatedType);
                            }
                        }
                );
    }

    @Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface MyAnnotation {

        int value();
    }


}
