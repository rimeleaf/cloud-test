package com.own.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
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

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
