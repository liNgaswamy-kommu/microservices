package com.eidiko.order_service.config;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfig {

    @Bean
    public Retry productServiceRetryLogger(RetryRegistry retryRegistry) {

        Retry retry = retryRegistry.retry("productService");

        retry.getEventPublisher()
                .onRetry(event ->
                        System.out.println(
                                "RETRY ATTEMPT: "
                                        + event.getNumberOfRetryAttempts()
                                        + " | "
                                        + event.getLastThrowable()
                        )
                );

        return retry;
    }
}

