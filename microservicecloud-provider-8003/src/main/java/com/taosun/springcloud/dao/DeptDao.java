package com.taosun.springcloud.dao;

import com.taosun.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {


    public Dept findById(Long deptno);

    public List<Dept> findAll();

    public boolean addDept(Dept d);

}
