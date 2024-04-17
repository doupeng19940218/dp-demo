package org.example;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.burukeyou.retry.spring.EnableFastRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "org.example")
@EnableCreateCacheAnnotation
@EnableAsync
@EnableFastRetry
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
