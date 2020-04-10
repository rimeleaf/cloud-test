package com.own.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ProductController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/6 14:34
 */
@RestController
@RequestMapping("/productFallbackFactory")
public class ProductSentinelFallbackFactoryController {

    @GetMapping("/getProductFallbackFactory/{id}")
    public String getProductFallbackFactory(@PathVariable int id) {
        System.out.println("获取ID为" + id + "的产品成功");
        return "获取ID为" + id + "的产品成功";

    }
}
