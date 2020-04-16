package com.own.controller;

import com.own.service.ITProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: ProductController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/6 14:34
 */
@Log4j2
@RestController
@RequestMapping("/productFallbackFactory")
public class ProductSentinelFallbackFactoryController {


    @GetMapping("/getProductFallbackFactory/{id}")
    public String getProductFallbackFactory(@PathVariable int id) {
        System.out.println("获取ID为" + id + "的产品成功");
        return "获取ID为" + id + "的产品成功";

    }

    @Autowired
    private ITProductService productService;

    @PostMapping("/inventory")
    public boolean inventory(@RequestParam(value = "id") int id,
                             @RequestParam(value = "num") int num) throws Exception {
        return productService.inventory(id, num);


    }
}
