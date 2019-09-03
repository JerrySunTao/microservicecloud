package com.taosun.springcloud.controller;

import com.taosun.springcloud.entities.Dept;
import com.taosun.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){

        return deptClientService.add(dept);

    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.get(id);

    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){

       return deptClientService.list();
    }

    //演示eureka服务发现
    @RequestMapping("/consumer/dept/discover")
    public Object discover(){

       return deptClientService.discover();
    }


}
