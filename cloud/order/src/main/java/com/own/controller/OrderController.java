package com.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @className: OrderController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/6 14:25
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("getProduct")
    public String getProduct() throws Exception {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("product-center");
        if (null == serviceInstanceList || 0 == serviceInstanceList.size()) {
            throw new Exception("没有可用的微服务");
        }
        String targetUri = serviceInstanceList.get(0).getUri().toString();
        String responseEntity = restTemplate.getForObject(targetUri + "/product/getProduct/1", String.class);

        return responseEntity;
    }
}
