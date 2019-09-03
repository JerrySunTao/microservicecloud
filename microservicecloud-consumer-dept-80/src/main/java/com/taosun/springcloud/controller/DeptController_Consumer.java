package com.taosun.springcloud.controller;

import com.taosun.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
//    private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);

    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    //演示eureka服务发现
    @RequestMapping("/consumer/dept/discover")
    public Object discover(){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discover",Object.class);
    }


}
