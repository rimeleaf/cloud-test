package com.own.api;

import com.own.config.ProductFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: ProductFeignApi
 * @Descripe： <br>
 * @package: com.own.api
 * @author: MECHREV
 * @date: 2020/4/7 17:18
 */
@FeignClient(name = "product-center", configuration = ProductFeignConfig.class)
@RequestMapping("/product")
public interface ProductFeignApi {

    /**
     * g
     * @param id
     * @return
     */
    @GetMapping("/getProduct/{id}")
    public String getProduct(@PathVariable int id);
}
