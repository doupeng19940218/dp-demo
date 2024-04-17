package org.example.controller;

import com.burukeyou.retry.core.annotations.FastRetry;
import com.burukeyou.retry.core.annotations.RetryWait;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker.dou
 */
@RestController
@RequestMapping("/fastRetry")
public class FastRetryController {


    @FastRetry(maxAttempts = 3, retryWait = @RetryWait(delay = 2))
    @GetMapping("/test")
    public void test(){
        System.out.println("fastRetry test");
        if (1 == 1){
            throw new RuntimeException("fastRetry test RuntimeException");
        }
    }
}
