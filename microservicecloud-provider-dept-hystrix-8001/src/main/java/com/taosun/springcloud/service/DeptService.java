package com.taosun.springcloud.service;

import com.taosun.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    public Dept get(Long deptno);

    public List<Dept> list();

    public boolean add(Dept d);
}
