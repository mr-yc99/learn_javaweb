package com.learnjava.demotlias.service.impl;

import com.learnjava.demotlias.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getDept();


    void deleteByID(Integer id);

    void addDept(Dept dept);

    List<Dept> getByID(Integer id);

    void update(Dept dept);
}
