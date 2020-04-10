package com.own;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MECHREV
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderRibbonSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderRibbonSentinelApplication.class, args);
	}

}
