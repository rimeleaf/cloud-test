package com.own.controller;

import com.own.api.ProductFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: OrderFeignController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/7 18:01
 */
@RestController
@RequestMapping("/order-feign")
public class OrderFeignController {
    @Autowired
    private ProductFeignApi productFeignApi;

    @GetMapping("getProduct")
    public String getProduct() throws Exception {

        String responseEntity = productFeignApi.getProduct(1);

        return responseEntity;
    }
}
