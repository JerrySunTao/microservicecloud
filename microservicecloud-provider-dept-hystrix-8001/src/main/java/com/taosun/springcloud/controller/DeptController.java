package com.taosun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.taosun.springcloud.entities.Dept;
import com.taosun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 演示服务的熔断，当服务出现异常时直接返回默认的返回结果
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get",threadPoolKey = "getIdThread",threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "1"),
            @HystrixProperty(name = "maxQueueSize",value = "20")
    })
    public Dept get(@PathVariable("id") Long id){

        Dept dept= deptService.get(id);
        if(null==dept){
            throw new RuntimeException();
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){

        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该ID：" + id + "没有对应的信息，null--@HystrixCommand");
        dept.setDb_source("no this database in mysql");
        return dept;
    }


}
