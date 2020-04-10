package com.own.api;

import com.own.config.ProductFeignConfig;
import com.own.sentinel.ProductFeignWithSentinelFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: ProductFeignApi
 * @Descripe： sentinel fallbackFactory参数测试
 * @package: com.own.api
 * @author: MECHREV
 * @date: 2020/4/7 17:18
 */
@FeignClient(name = "product-center",  configuration = ProductFeignConfig.class, fallbackFactory = ProductFeignWithSentinelFallBackFactory.class)
@RequestMapping("/productFallbackFactory")
public interface ProductFeignWithSentinelFallBackFactoryApi {

    /**
     * g
     *
     * @param id
     * @return
     */
    @GetMapping("/getProductFallbackFactory/{id}")
    public String getProductFallbackFactory(@PathVariable int id);
}
