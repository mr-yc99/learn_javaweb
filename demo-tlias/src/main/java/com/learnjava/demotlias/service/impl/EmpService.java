package com.learnjava.demotlias.service.impl;

import com.learnjava.demotlias.pojo.Emp;
import com.learnjava.demotlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean getByPage(Integer page, Integer pageSize,
                       String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByID(List<Integer> ids);

    void addEmp(Emp emp);

    void putEmp(Emp emp);

    Emp getByID(Integer id);

    Emp processLogin(Emp emp);
}
