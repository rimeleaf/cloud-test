package com.own.config.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @className: OwnRequestOriginParser
 * @Descripe： 夸服务调用带上Origin信息
 * @package: com.own.config.handler
 * @author: MECHREV
 * @date: 2020/4/9 23:19
 */
@Component
public class OwnRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String origin = httpServletRequest.getHeader("origin");
        return origin;
    }
}
