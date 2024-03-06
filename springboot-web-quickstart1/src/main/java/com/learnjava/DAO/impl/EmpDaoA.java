package com.learnjava.DAO.impl;

import com.learnjava.DAO.EmpDAO;
import com.learnjava.pojo.demo1.Emp;
import com.learnjava.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDAO {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empPojo = XmlParserUtils.parse(file, Emp.class);
        return empPojo;
    }
}
