package com.own.controller;

import com.own.api.ProductFeignApi;
import com.own.api.ProductFeignWithSentinelFallBackFactoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/order-feign-sentinel")
public class OrderFeignController {
    @Autowired
//    @Qualifier("product")
    private ProductFeignApi productFeignApi;

//    @Autowired
//    @Qualifier("product-fallback")
//    private ProductFeignWithSentinelFallBackApi productFeignWithSentinelFallBackApi;

    @Autowired
//    @Qualifier("product-fallbackFactory")
    private ProductFeignWithSentinelFallBackFactoryApi productFeignWithSentinelFallBackFactoryApi;

    @GetMapping("getProduct")
    public String getProduct() throws Exception {

        String responseEntity = productFeignApi.getProduct(1);

        return responseEntity;
    }

    @GetMapping("getNum/{num}")
    public Integer getNum(@PathVariable int num) throws Exception {

        return num;
    }

    @GetMapping("getStr/{str}")
    public String getStr(@PathVariable String str) throws Exception {
        return str;
    }
//    @GetMapping("getProductFallBack")
//    public String getProductFallback() throws Exception {
//
//        String responseEntity = productFeignWithSentinelFallBackApi.getProductFallback(1);
//
//        return responseEntity;
//    }

    @GetMapping("getProductFallBackFactory")
    public String getProductFallBackFactory() throws Exception {

        String responseEntity = productFeignWithSentinelFallBackFactoryApi.getProductFallbackFactory(1);

        return responseEntity;
    }
}
