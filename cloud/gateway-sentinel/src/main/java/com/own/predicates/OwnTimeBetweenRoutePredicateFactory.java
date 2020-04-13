package com.own.predicates;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @className: OwnBetweenRoutePredicatesfFactory
 * @Descripe： <br>
 * @package: com.own.predicates
 * @author: MECHREV
 * @date: 2020/4/13 17:38
 */
@Component
@Log4j2
public class OwnTimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<OwnTimeBetweenRoutePredicateFactory.Config> {


    public OwnTimeBetweenRoutePredicateFactory() {
        super(OwnTimeBetweenRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("startTime", "endTime");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        log.info("配置-开始时间: {}", config.getStartTime());
        log.info("配置-结束时间: {}", config.getEndTime());

        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                LocalTime now = LocalTime.now();
                return now.isAfter(config.getStartTime()) && now.isBefore(config.getEndTime());
            }
        };
    }


    @Setter
    @Getter
    @Validated
    public static class Config {
        @NotNull
        private LocalTime startTime;
        @NotNull
        private LocalTime endTime;

    }
}
