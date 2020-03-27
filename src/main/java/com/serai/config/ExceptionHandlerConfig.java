package com.serai.config;

import com.serai.exception.ExceptionHandlerServiceImpl;
import com.serai.exception.ExceptionHandlerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionHandlerConfig {
    @Bean
    public ExceptionHandlerService exceptionHandlerService() {
        return new ExceptionHandlerServiceImpl();
    }
}
