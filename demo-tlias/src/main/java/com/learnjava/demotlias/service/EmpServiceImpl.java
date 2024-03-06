package com.learnjava.demotlias.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learnjava.demotlias.mapper.EmpMapper;
import com.learnjava.demotlias.pojo.Emp;
import com.learnjava.demotlias.pojo.PageBean;
import com.learnjava.demotlias.service.impl.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean getByPage(Integer page, Integer pageSize,
                              String name, Short gender, LocalDate begin, LocalDate end) {
//        Long rows = empMapper.countRow();
//        page = (page - 1) * pageSize;

//        List<Emp> empList = empMapper.getEmp(page, pageSize);
        PageHelper.startPage(page, pageSize);

        List<Emp> byPage = empMapper.getByPage(name, gender, begin, end);

        Page<Emp> p = (Page<Emp>) byPage;

        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteByID(List<Integer> ids) {
        empMapper.deleteByID(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.addEmp(emp);
    }

    @Override
    public void putEmp(Emp emp) {
        empMapper.putEmp(emp);
        emp.setUpdateTime(LocalDateTime.now());
    }

    @Override
    public Emp getByID(Integer id) {
        Emp byID = empMapper.getByID(id);
        return byID;
    }

    @Override
    public Emp processLogin(Emp emp) {
        Emp e = empMapper.processLogin(emp);



        return e;
    }
}
