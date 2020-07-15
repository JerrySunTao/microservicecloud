package com.taosun.springcloud.service;

import com.taosun.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 演示服务降级
 * 当调用服务器的某个方法时，而此时服务器已经出现异常或服务崩溃，则可以通过服务降级直接返回一些默认的结果给调用方
 * 不至于调用方无限等待拖垮整个服务
 *
 * 注意需要加上以下扫描注解，否则找不到相关bean
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService(){

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID：" + id + "没有对应的信息，Consumer客户端提供的信息，此服务Provider已关闭"+throwable);
                dept.setDb_source("no this database in mysql");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Object discover() {
                return null;
            }
        };
    }
}
