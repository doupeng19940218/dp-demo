package org.example.config;

import org.example.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author walker.dou
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Result exceptionHandlerRuntimeException(Exception e) {
        logger.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    // 或者其它自定义异常
}
