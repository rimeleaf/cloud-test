package com.own.filter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @className: OwnGlobalFilter
 * @Descripe： <br>
 * @package: com.own.filter
 * @author: MECHREV
 * @date: 2020/4/13 23:25
 */
//@Component
public class OwnGlobalFilter implements GlobalFilter, Ordered, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
