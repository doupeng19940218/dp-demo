package org.example.other;

import java.util.function.Supplier;

/**
 * @author walker.dou
 */
public class SneakilyThrowException {
    public static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
        throw (T) t;
    }
//
//    public static <T, R> Function<T, R> unchecked(FunctionWithThrow<T, R> f) {
//        return t -> {
//            try {
//                return f.apply(t);
//            } catch (Exception ex) {
//                return SneakilyThrowException.sneakyThrow(ex);
//            }
//        };
//    }

    public static <T> Supplier<T> unchecked(SupplierWithThrow<T> f) {
        return () -> {
            try {
                return f.get();
            } catch (Exception ex) {
                return SneakilyThrowException.sneakyThrow(ex);
            }
        };
    }

//    public static <T> Consumer<T> unchecked(ConsumerWithThrow<T> f) {
//        return t -> {
//            try {
//                f.consume(t);
//            } catch (Exception ex) {
//                SneakilyThrowException.sneakyThrow(ex);
//            }
//        };
//    }

    @FunctionalInterface
    public interface FunctionWithThrow<T, R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface SupplierWithThrow<T> {
        T get() throws Exception;
    }

    @FunctionalInterface
    public interface ConsumerWithThrow<T> {
        void consume(T t) throws Exception;
    }
}
