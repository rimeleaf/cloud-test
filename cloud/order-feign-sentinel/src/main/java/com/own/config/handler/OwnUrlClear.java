package com.own.config.handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @className: OwnUrlClean
 * @Descripe： restful 地址清洗
 * @package: com.own.config.handler
 * @author: MECHREV
 * @date: 2020/4/9 23:16
 */
@Component
public class OwnUrlClear implements UrlCleaner {
    @Override
    public String clean(String s) {
//        /order-feign-sentinel/getStr/1
        List<String> origins = Arrays.asList(s.split("/"));
        StringBuffer stringBuffer = new StringBuffer("");
        for (String orig : origins) {
            if (NumberUtils.isDigits(orig)) {
                stringBuffer.append("/{number}");
            } else {
                stringBuffer.append("/").append(orig);
            }
        }
        return stringBuffer.toString();
    }

}
