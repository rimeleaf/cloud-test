package com.own;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MECHREV
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignSentinelApplication.class, args);
    }

}
