package org.example;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Pattern;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "org.example")
@EnableCreateCacheAnnotation
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    String regex = "^\\d{3}16190.*|^31721294700.*|^31721295100.*";
    Pattern pattern = Pattern.compile(regex);
}
