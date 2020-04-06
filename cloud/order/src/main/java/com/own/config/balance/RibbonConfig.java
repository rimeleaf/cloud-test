package com.own.config.balance;

import com.own.config.ribbon.PayRibbonConfig;
import com.own.config.ribbon.ProductRibbonConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RibbonConfig
 * @Descripe： <br>
 * @package: com.own.config.balance
 * @author: MECHREV
 * @date: 2020/4/6 21:09
 */
//@Configuration
//@RibbonClients({@RibbonClient(value = "product-center", configuration = {ProductRibbonConfig.class}),
//        @RibbonClient(value = "pay-center", configuration = {PayRibbonConfig.class})})
public class RibbonConfig {
}
