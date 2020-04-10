package com.own.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.own.handler.GlobalExceptionHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @className: WebConfig
 * @Descripe： <br>
 * @package: com.own.config
 * @author: MECHREV
 * @date: 2020/4/6 14:43
 */
@Configuration
public class WebConfig {


    @Bean
    @LoadBalanced
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = GlobalExceptionHandler.class,
            fallback = "fallback", fallbackClass = GlobalExceptionHandler.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
