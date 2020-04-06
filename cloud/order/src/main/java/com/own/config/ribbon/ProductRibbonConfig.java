package com.own.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: ProductRibbonConfig
 * @Descripe： <br>
 * @package: com.own.config.ribbon
 * @author: MECHREV
 * @date: 2020/4/6 21:04
 */
//@Configuration
public class ProductRibbonConfig {

//    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
