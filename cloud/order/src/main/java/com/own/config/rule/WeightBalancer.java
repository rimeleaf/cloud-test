package com.own.config.rule;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;

import java.util.List;

/**
 * @className: WeightBalancer
 * @Descripe： <br>
 * @package: com.own.config.rule
 * @author: MECHREV
 * @date: 2020/4/7 14:59
 */
public class WeightBalancer extends Balancer {

    public static Instance getInstanceByRandomWeight(List<Instance> instanceList) {
        return getHostByRandomWeight(instanceList);
    }
}
