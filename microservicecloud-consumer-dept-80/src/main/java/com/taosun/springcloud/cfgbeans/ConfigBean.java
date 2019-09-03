package com.taosun.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类用于代替传统的spring配置文件，ApplicationContext.xml
 */
@Configuration
public class ConfigBean {
    //添加ribbon负载均衡注解
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 切换ribbon负载均衡
     *
     * 注：
     * 若在后面使用了自定义负载算法，则需要将此处ribbon自己的负载算法注视掉，不然后台就会报错：
     * 非唯一的负载算法
     */

//    @Bean
//    public IRule myRule(){
//
//        return new RandomRule();//默认轮训，切换到随机
//
//    }

}
