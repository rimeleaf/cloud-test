package com.own.config.handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 */
@Component
public class OwnUrlBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        if( e instanceof FlowException){
            warrperResponse(httpServletResponse, "触发了流控");
        }else if (e instanceof ParamFlowException) {
            warrperResponse(httpServletResponse, "触发了参数流控");
        }else if(e instanceof AuthorityException){
            warrperResponse(httpServletResponse,"权限校验不通过");
        }else  if(e instanceof SystemBlockException){
            warrperResponse(httpServletResponse,"触发了系统规则");
        }else {
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
