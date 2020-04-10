package com.own.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ConfigTestController
 * @Descripe： <br>
 * @package: com.own.controller
 * @author: MECHREV
 * @date: 2020/4/8 14:52
 */
@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${own.name}")
    private String ownName;

    @Value("${own.refresh}")
    private Boolean ownRefresh;

    @Value(value = "${own.server}")
    private String ownServer;

    @Value("${common.desc}")
    private String commonDesc;

    @Value("${common.usefor}")
    private String commonUseFor;

    @Value("${common.name}")
    private String name;


    @Value("${test.name}")
    private String testName;

    @GetMapping("/test1")
    public boolean testNacosConfigCenter() {
        System.out.println("ownName: " + ownName);
        System.out.println("ownRefresh: " + ownRefresh);
        System.out.println("ownServer: " + ownServer);
        System.out.println("commonDesc: " + commonDesc);
        System.out.println("commonUseFor: " + commonUseFor);
        System.out.println("name: " + name);
        System.out.println("testName: " + testName);
        return true;

    }


}
