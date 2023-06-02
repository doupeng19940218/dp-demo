package org.example.other;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author walker.dou
 */
class UnsafeTest {
    @SneakyThrows
    @Test
    void demo() {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        final Unsafe unsafe = (Unsafe) field.get(null);

    }
}
