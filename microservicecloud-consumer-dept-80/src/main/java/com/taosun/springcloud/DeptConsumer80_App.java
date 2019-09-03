package com.taosun.springcloud;

import com.taosun.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * ribbon为客户端的负载均衡器，与eureka整合后可以通过微服务名称直接访问服务端
 *
 * 添加自定义的ribbon负载均衡算法：
 * 需要在主启动类下添加注解
 * @RibbonClient(name = "microservicecloud-dept",configuration = 自定义类名)
 *这个自定义的类不能放在@ComponentScan所扫描的当前包以及子包下，
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，
 * 也就是我们达不到特殊化指定的目的了。
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MyselfRule.class)
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
