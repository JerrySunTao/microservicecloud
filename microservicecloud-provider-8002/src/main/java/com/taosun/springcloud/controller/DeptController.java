package com.taosun.springcloud.controller;

import com.taosun.springcloud.entities.Dept;
import com.taosun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){

        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){

//
        Dept dept = new Dept();
        dept.setDname("qew");
        return dept;
    }

    @RequestMapping(value = "/dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discover",method = RequestMethod.GET)
    public Object discover(){

        //获取微服务列表
        List<String> list=discoveryClient.getServices();
        System.out.println("================list:"+list);

        //获取单个微服务信息
        List<ServiceInstance> listSrv=discoveryClient.getInstances("microservicecloud-dept");
        for (ServiceInstance serviceInstance :listSrv){
            System.out.println(
                    serviceInstance.getServiceId()+"\t"+
                    serviceInstance.getHost()+"\t"+
                    serviceInstance.getPort()+"\t"+
                    serviceInstance.getUri()
            );
        }

        return this.discoveryClient;
    }

}
