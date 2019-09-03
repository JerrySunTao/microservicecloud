package com.taosun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptno;//主键
    private String dname;//名称
    private String db_source;//数据库名称

    public static void main(String[] args) {
        Dept d=new Dept();
        d.getDb_source();
    }
}
