package com.taosun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 1.有zuul的情况下可以直接通过zuul+微服务注册名的方式来进行微服务的访问，
 * 2.可以通过ribbon的方式：restTemplaet+微服务注册名
 * 3.feign方式：可以通过接口的方式直接进行微服务的访问
 * 注：定义接口需要参考服务端的controller,即把controller里面的方法实现删除其他的当作接口内容
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSrpingCloudApp {

    public static void main(String[] args) {

        SpringApplication.run(Zuul_9527_StartSrpingCloudApp.class,args);
    }
}
