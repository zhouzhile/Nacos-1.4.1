package com.alibaba.nacos.sentinel.rules;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.nacos.sentinel.contant.RuleContans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SentinelRules
 * @Desc Sentinel规则使用
 * @Author Lenovo
 * @Date 2023/1/3 21:41
 * @Version 1.0
 **/
@Configuration
public class SentinelRules {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return new SentinelResourceAspect();
    }

    /**
     * 定义规则-流控规则
     */
//    @PostConstruct  //
//    private void initFlowRules(){
//        // 流控规则
//        List<FlowRule> rules = new ArrayList<>();
//        // 流控
//        FlowRule rule = new FlowRule();
//        // 为哪个资源进行流控
//        rule.setResource(RuleContans.RESOURCE_NAME);
//        // 设置流控规则 QPS
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // 设置受保护的资源阈值
//        // Set limit QPS to 20.
//        rule.setCount(3);
//        rules.add(rule);
//        // 加载配置好的规则
//        FlowRuleManager.loadRules(rules);
//    }

    /**
     * 定义规则-熔断降级规则
     */
    @PostConstruct  //
    private void initDegradeRule(){
        // 熔断降级规则
        List<DegradeRule> rules = new ArrayList<>();
        // 流控
        DegradeRule rule = new DegradeRule();
        // 资源
        rule.setResource(RuleContans.RESOURCE_NAME);
        // 设置规则策略,支持慢调用比例/异常比例/异常数策略.....这里使用异常数
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // 触发熔断异常数 ： 2
        rule.setCount(5);
        // 触发熔断最小请求数
        rule.setMinRequestAmount(5);
        // 统计时长，单位为ms,默认1000ms
        rule.setStatIntervalMs(60*1000);
        // 熔断持续时长，单位s
        rule.setTimeWindow(10);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }


}
