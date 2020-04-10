package com.own.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @className: OwnFeignConfig
 * @Descripe： <br>
 * @package: com.own.config
 * @author: MECHREV
 * @date: 2020/4/7 17:17
 */
public class ProductFeignConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public Contract feiContract() {
//        return new Contract.Default();
//    }



}
