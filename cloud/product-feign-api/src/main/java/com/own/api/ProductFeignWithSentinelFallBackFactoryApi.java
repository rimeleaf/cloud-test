package com.own.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @className: ProductFeignApi
 * @Descripe： sentinel fallbackFactory参数测试
 * @package: com.own.api
 * @author: MECHREV
 * @date: 2020/4/7 17:18
 */
//@FeignClient(name = "product-center", configuration = ProductFeignConfig.class, fallbackFactory = ProductFeignWithSentinelFallBackFactory.class)
@FeignClient(name = "product-center")
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

    @PostMapping("/inventory")
    public boolean inventory(@RequestParam(value = "id") int id,
                             @RequestParam(value = "num") int num) throws Exception;


}
