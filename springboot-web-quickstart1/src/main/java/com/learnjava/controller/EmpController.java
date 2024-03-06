package com.learnjava.controller;

import com.learnjava.pojo.Result;
import com.learnjava.pojo.demo1.Emp;
import com.learnjava.service.EmpService;
import com.learnjava.service.impl.EmpServiceA;
import com.learnjava.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> emps = empService.listEmp();


        return Result.success(emps);
    }
}
