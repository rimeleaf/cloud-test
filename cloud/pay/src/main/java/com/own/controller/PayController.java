package com.own.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: PayController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/6 20:50
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @RequestMapping(value = "/pfp", method = RequestMethod.POST)
    public String payForProduct() {
        System.out.println("支付成功！");
        return "支付成功！";

    }
}
