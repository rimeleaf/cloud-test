package com.own.config.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: SameClusterPriorityRule
 * @Descripe： 同版本之间调用，相同集群优先且采用权重策略，不用集群集群采用随机策略
 * @package: com.own.config.rule
 * @author: MECHREV
 * @date: 2020/4/7 14:19
 */
public class SameVersionAndSameClusterPriorityRule extends AbstractLoadBalancerRule {

    public final static String METADATA_VERSION_NAME = "version";

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {


    }

    @Override
    public Server choose(Object key) {
        try {
            String currentClusterName = nacosDiscoveryProperties.getClusterName();
            String currentVersion = nacosDiscoveryProperties.getMetadata().get(METADATA_VERSION_NAME);
            List<Instance> instanceList = getAllInstances();
            List<Instance> sameVersionInstances = instanceList.stream()
                    .filter(instance -> currentVersion.equals(instance.getMetadata().get(METADATA_VERSION_NAME))).
                            collect(Collectors.toList());
            if (!sameVersionInstances.isEmpty()) {
                List<Instance> sameVersionAndSameClusterInstances = sameVersionInstances.stream()
                        .filter(inst -> currentClusterName.equals(inst.getClusterName()))
                        .collect(Collectors.toList());
                if (!sameVersionAndSameClusterInstances.isEmpty()) {
                    // 权重
                    Instance instance = WeightBalancer.getInstanceByRandomWeight(sameVersionAndSameClusterInstances);
                    return new NacosServer(instance);
                } else {
                    RandomRule randomRule = new RandomRule();
                    return randomRule.choose(getLoadBalancer(), "key");
                }
            } else {
                return null;
            }


        } catch (Exception e) {
            return null;
        }
    }

    public List<Instance> getAllInstances() throws NacosException {
        //第1步:获取一个负载均衡对象
        BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) getLoadBalancer();
        //第2步:获取当前调用的微服务的名称
        String invokeServiceName = baseLoadBalancer.getName();
        //第3步:获取nacos clinet的服务注册发现组件的api
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        String groupName = nacosDiscoveryProperties.getGroup();
        //第4步:获取所有的服务实例
        List<Instance> instanceList = namingService.getAllInstances(invokeServiceName, groupName);
        return instanceList;

    }
}
