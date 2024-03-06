package com.learnjava.demotlias.service;

import com.learnjava.demotlias.DemoTliasApplication;
import com.learnjava.demotlias.mapper.DeptMapper;
import com.learnjava.demotlias.mapper.EmpMapper;
import com.learnjava.demotlias.pojo.Dept;
import com.learnjava.demotlias.service.impl.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Dept> getDept() {
        return deptMapper.getDept();
    }

    @Transactional
    @Override
    public void deleteByID(Integer id) {
        deptMapper.deleteByID(id);
        empMapper.deleteByDeptId(id);




    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public List<Dept> getByID(Integer id) {
        List<Dept> depts = deptMapper.getByID(id);
        return depts;

    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
