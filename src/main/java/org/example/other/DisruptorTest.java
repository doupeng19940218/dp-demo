package org.example.other;


import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static com.lmax.disruptor.dsl.ProducerType.SINGLE;

/**
 * @author walker.dou
 */
public class DisruptorTest {

    @Test
    public void demo() {
// 环形数组长度，必须是2的n次幂
        int ringBufferSize = 1024;
        // 创建事件（Event）对象的工厂
        MyEventFactory<String> eventFactory = new MyEventFactory<>();
        // 创建消费者线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // 等待策略
        WaitStrategy waitStrategy = new SleepingWaitStrategy();
        Disruptor<MyEvent<String>> disruptor =
                new Disruptor<>(eventFactory, ringBufferSize, threadFactory, SINGLE, waitStrategy);

        // 指定一个处理器
        MyEventHandler<String> eventHandler = new MyEventHandler<>();
        disruptor.handleEventsWith(eventHandler);
        // 处理器异常处理器
        ExceptionHandler<MyEvent<String>> exceptionHandler = new MyExceptionHandler<>();
        disruptor.setDefaultExceptionHandler(exceptionHandler);

        disruptor.start();

        // 通过事件转换器（EventTranslator）来指明如何将发布的数据转换到事件对象（Event）中
        // 这里是一个参数的转换器，另外还有两个（EventTranslatorTwoArg）、三个（EventTranslatorThreeArg）
        // 和多个（EventTranslatorVararg）参数的转换器可以使用，参数类型可以不一样
        EventTranslatorOneArg<MyEvent<String>, String> eventTranslatorOneArg =
                new EventTranslatorOneArg<MyEvent<String>, String>() {
                    @Override
                    public void translateTo(MyEvent<String> event, long sequence, String arg0) {
                        event.setData(arg0);
                    }
                };

        // 发布
        for (int i = 0; i < 10; i++) {
            disruptor.publishEvent(eventTranslatorOneArg, "One arg " + i);
        }

        disruptor.shutdown();
    }
}


class MyEvent<T> {

    private T data;

    public T getData() {
        return data;
    }

    public MyEvent<T> setData(T data) {
        this.data = data;
        return this;
    }
}

class MyEventFactory<T> implements EventFactory<MyEvent<T>> {

    @Override
    public MyEvent<T> newInstance() {
        return new MyEvent<>();
    }
}

class MyEventHandler<T> implements EventHandler<MyEvent<T>> {

    @Override
    public void onEvent(MyEvent<T> tMyEvent, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + "MyEventHandler消费：" + tMyEvent.getData());
    }
}

class MyExceptionHandler<T> implements ExceptionHandler<MyEvent<T>> {

    @Override
    public void handleEventException(Throwable ex, long sequence, MyEvent<T> event) {
        System.out.println("handleEventException");
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        System.out.println("handleOnStartException");
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        System.out.println("handleOnShutdownException");
    }
}






