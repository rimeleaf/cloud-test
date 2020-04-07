package com.own.config.balance;

import com.netflix.loadbalancer.IRule;
import com.own.config.rule.SameVersionAndSameClusterPriorityRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RibbonConfig
 * @Descripe： 通过配置类的方式来配置负载均衡策略，不推荐使用这种方式，推荐配置文件的方式
 * @package: com.own.config.balance
 * @author: MECHREV
 * @date: 2020/4/6 21:09
 */
//@Configuration
//@RibbonClients({@RibbonClient(value = "product-center", configuration = {ProductRibbonConfig.class}),
//        @RibbonClient(value = "pay-center", configuration = {PayRibbonConfig.class})})
//@Configuration
public class RibbonConfig {
//    @Bean
//    public IRule sameVersionAndSameClusterPriorityRule() {
//        return new SameVersionAndSameClusterPriorityRule();
//    }
}
