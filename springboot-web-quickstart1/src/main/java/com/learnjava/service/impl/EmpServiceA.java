package com.learnjava.service.impl;

import com.learnjava.DAO.EmpDAO;
import com.learnjava.DAO.impl.EmpDaoA;
import com.learnjava.pojo.demo1.Emp;
import com.learnjava.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDAO empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empPojo = empDao.listEmp();
        empPojo.stream().forEach(emp -> {
            String gender = emp.getGender();
            if( "1".equals(gender)) {
                emp.setGender("男");
            }else {
                emp.setGender("女");
            }

            String job = emp.getJob();
            if( "1".equals(job)) {
                emp.setJob("讲师");
            }else if ("2".equals(job)){
                emp.setJob("班主任");
            }else {
                emp.setJob("就业指导");
            }
        });
        return empPojo;
    }
}
