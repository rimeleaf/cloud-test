package com.own.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @className: TimeMonitorGatewayFilterFactory
 * @Descripe： <br>
 * @package: com.own.filter
 * @author: MECHREV
 * @date: 2020/4/13 22:57
 */
@Component
@Log4j2
public class TimeMonitorGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        String name = config.getName();
        String value = config.getValue();
        log.info("name:{}, value:{}", name, value);
        if ("false".equals(config.getValue())) {
            return null;
        }
        return new GatewayFilter() {

            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                exchange.getAttributes().put("COUNT_START_TIME", System.currentTimeMillis());

                //then方法相当于aop的后置通知一样
                return chain.filter(exchange).then(Mono.fromRunnable(new Runnable() {
                    @Override
                    public void run() {
                        long startTime = exchange.getAttribute("COUNT_START_TIME");
                        StringBuilder stringBuilder = new StringBuilder(exchange.getRequest().getURI().getPath());
                        stringBuilder.append(":")
                                .append(System.currentTimeMillis() - startTime);
                        log.info(stringBuilder.toString());
                    }
                }));
            }
        };
    }
}
