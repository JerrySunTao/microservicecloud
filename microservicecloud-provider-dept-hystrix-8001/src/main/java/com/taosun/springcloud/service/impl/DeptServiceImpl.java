package com.taosun.springcloud.service.impl;

import com.taosun.springcloud.dao.DeptDao;
import com.taosun.springcloud.entities.Dept;
import com.taosun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public Dept get(Long deptno) {
        return deptDao.findById(deptno);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }

    @Override
    public boolean add(Dept d) {
        return deptDao.addDept(d);
    }
}
