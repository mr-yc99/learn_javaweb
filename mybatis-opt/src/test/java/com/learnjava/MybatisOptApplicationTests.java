package com.learnjava;

import com.learnjava.mapper.EmpMapper;
import com.learnjava.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisOptApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDeleteEmp() {
        int deleteNum = empMapper.deleteEmp(18);
        System.out.println(deleteNum);
    }

    @Test
    public void updateEmp() {
        Emp emp = new Emp();
        emp.setId(16);
        emp.setUsername("Tom1");
        emp.setName("tangmumao");
        emp.setImage("1.jgp");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 4, 6));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }

    @Test
    public void testQuery(){
        Emp test = empMapper.queryByID(1);
        System.out.println(test);

    }
//动态SQL
    @Test
    public void testQuery2() {
//        List<Emp> test = empMapper.queryByTerm("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        List<Emp> test = empMapper.queryByTerm(null,(short) 1, null, null);
        System.out.println(test);

    }

    @Test
    public void deleteMore(){
        List<Integer> list = Arrays.asList(16);
        empMapper.deleteByIDs(list);
    }

}
