package org.example.fastRetry;

import com.burukeyou.retry.core.*;
import com.burukeyou.retry.core.support.RetryQueueFuture;
import com.burukeyou.retry.core.task.RetryTask;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author walker.dou
 */
@Slf4j
public class FastRetryDemo {

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        RetryQueue queue = new FastRetryQueue(executorService);
        RetryTask<String> task = new RetryTask<String>() {
            int result = 0;

            // 下一次重试的间隔
            @Override
            public long waitRetryTime() {
                return 2000;
            }

            // 执行重试，每次重试回调此方法
            @Override
            public boolean retry() {
                System.out.println(result);
                return ++result < 5;
            }

            // 获取重试结果
            @Override
            public String getResult() {
                return result + "";
            }
        };
        CompletableFuture<String> future = queue.submit(task);
        log.info("任务结束 结果:{}", future.get());
    }

    @SneakyThrows
    public static void main2(String[] args) {
        RetryResultPolicy<String> resultPolicy;
        resultPolicy = result -> result.equals("444");
        FastRetryer<String> retryer = FastRetryBuilder.<String>builder()
                .attemptMaxTimes(3)
                .waitRetryTime(3, TimeUnit.SECONDS)
                .retryIfException(true)
                .retryIfExceptionOfType(TimeoutException.class)
                .exceptionRecover(true)
                .resultPolicy(resultPolicy)
                .build();

        CompletableFuture<String> future = retryer.submit(() -> {
            log.info("重试");
            //throw new Exception("test");
            //int i = 1/0;
            if (0 < 10) {
                throw new TimeoutException("test");
            }
            return "444";
        });

        String o = future.get();
        log.info("结果{}", o);

    }
}
