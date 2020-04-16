package com.own.config.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: OwnUrlBlockHandler
 * @Descripe： 熔断全局异常
 * @package: com.own.config.handler
 * @author: MECHREV
 * @date: 2020/4/10 10:08
 *
 *  UrlBlockHandler
 */
@Component
@Log4j2
public class OwnUrlBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        if( e instanceof FlowException){
            log.info("触发了流控");
            warrperResponse(httpServletResponse, "触发了流控");
        }else if (e instanceof ParamFlowException) {
            log.info("触发了参数流控");
            warrperResponse(httpServletResponse, "触发了参数流控");
        }else if(e instanceof AuthorityException){
            log.info("权限校验不通过");
            warrperResponse(httpServletResponse,"权限校验不通过");
        }else  if(e instanceof SystemBlockException){
            log.info("触发了系统规则");
            warrperResponse(httpServletResponse,"触发了系统规则");
        }else {
            log.info("触发了降级规则");
            warrperResponse(httpServletResponse,"触发了降级规则");
        }
    }

    public void warrperResponse(HttpServletResponse httpServletResponse, String msg) throws IOException {
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String errMsg = objectMapper.writeValueAsString(msg);
        httpServletResponse.getWriter().write(errMsg);

    }

}
