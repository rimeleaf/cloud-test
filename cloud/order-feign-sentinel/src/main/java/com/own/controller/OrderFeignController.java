package com.own.controller;

import com.own.api.ProductFeignApi;
import com.own.api.ProductFeignWithSentinelFallBackFactoryApi;
import com.own.entity.TOrder;
import com.own.service.ITOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: OrderFeignController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/7 18:01
 */
@RestController
@RequestMapping("/order-feign-sentinel")
@Log4j2
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

    @Autowired
    private ITOrderService orderService;

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

    @PostMapping("/add")
    public boolean addOrder(@ModelAttribute TOrder tOrder) {
        boolean result = false;
        try {
            result = orderService.saveOrder(tOrder);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("订单添加失败：{}", e.getMessage());
        }

        return result;


    }
}
