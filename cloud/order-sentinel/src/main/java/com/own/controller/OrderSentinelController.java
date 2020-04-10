package com.own.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.own.utils.BlockUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className: Controller
 * @Descripe： <br>
 * @package: com.own
 * @author: MECHREV
 * @date: 2020/4/9 15:43
 */
@RestController
@Log4j2
public class OrderSentinelController {
    @PostConstruct
    private void init() {
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule1 = new FlowRule();
        flowRule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule1.setResource("helloSentinelV1");
        flowRule1.setCount(1);
        flowRules.add(flowRule1);

        FlowRule flowRule2 = new FlowRule();
        flowRule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule2.setResource("helloSentinelV2");
        flowRule2.setCount(1);
        flowRules.add(flowRule2);

        FlowRule flowRule3 = new FlowRule();
        flowRule3.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule3.setResource("helloSentinelV3");
        flowRule3.setCount(1);
        flowRules.add(flowRule3);
        FlowRuleManager.loadRules(flowRules);
    }

    @GetMapping("/helloSentinelV1")
    public String testHelloSentinelV1() {
        Entry entry = null;
        try {
            entry = SphU.entry("helloSentinelV1");
            log.info(new Date());
        } catch (Exception e) {
            log.info("testHelloSentinelV1方法被流控了");
            return "testHelloSentinelV1方法被流控了";
        } finally {
            assert entry != null;
            entry.exit();
        }
        return "ok";
    }

    @GetMapping("/helloSentinelV2")
    @SentinelResource(value = "helloSentinelV2", blockHandler = "blockHandlerTestHelloSentinelV2")
    public String testHelloSentinelV2() {
        return "ok";

    }

    public String blockHandlerTestHelloSentinelV2(BlockException e) {
        return "限流：" + e.getMessage();

    }

    @GetMapping("/helloSentinelV3")
    @SentinelResource(value = "helloSentinelV3", blockHandler = "blockHandlerTestHelloSentinelV3", blockHandlerClass = BlockUtils.class)
    public String testHelloSentinelV3() {
        return "ok";

    }

    @GetMapping("/helloSentinelV4")
    public String testHelloSentinelV4() {
        return "ok";

    }
}
