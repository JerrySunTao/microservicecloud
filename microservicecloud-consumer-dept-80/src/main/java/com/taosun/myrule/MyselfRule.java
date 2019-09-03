package com.taosun.myrule;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRule {

    //自定义的ribbon负载均衡

    @Bean
    public IRule getIRule(){

        return  new RandomRule_ZY();

    }
}
