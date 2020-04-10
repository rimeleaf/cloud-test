package com.own.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: PayRibbonConfig
 * @Descripe： pay负载均衡策略
 * @package: com.own.config.ribbon
 * @author: MECHREV
 * @date: 2020/4/6 21:06
 */
//@Configuration
public class PayRibbonConfig {

//    @Bean
    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}
