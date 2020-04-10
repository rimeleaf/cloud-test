package com.own.sentinel;

import com.own.api.ProductFeignWithSentinelFallBackFactoryApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @className: ProductFeignWithSentinelFallBackFactory
 * @Descripe： <br>
 * @package: com.own.sentinel
 * @author: MECHREV
 * @date: 2020/4/9 18:35
 */
@Component
public class ProductFeignWithSentinelFallBackFactory implements FallbackFactory<ProductFeignWithSentinelFallBackFactoryApi> {
    @Override
    public ProductFeignWithSentinelFallBackFactoryApi create(Throwable throwable) {
        return new ProductFeignWithSentinelFallBackFactoryApi() {

            @Override
            public String getProductFallbackFactory(int id) {
                return "FallbackFactory-被限制了";
            }
        };
    }
}
