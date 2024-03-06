package com.learnjava.demotlias.controller;


import com.learnjava.demotlias.pojo.Emp;
import com.learnjava.demotlias.pojo.PageBean;
import com.learnjava.demotlias.pojo.Result;
import com.learnjava.demotlias.service.impl.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;


    @GetMapping
    public Result getByPage(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            String name, Short gender,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("getByPage, 分页查询" + page +"&" + pageSize);
        PageBean byPage = empService.getByPage(page, pageSize, name, gender, begin, end);

        return Result.success(byPage);
    }

    @DeleteMapping("/{ids}")
    public Result deleteByID(@PathVariable List<Integer> ids) {
        empService.deleteByID(ids);


        return Result.success();
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getByID(@PathVariable Integer id) {
        log.info("查询员工id ：{}", id);

        Emp byID = empService.getByID(id);

        return Result.success(byID);
    }


    @PutMapping
    public Result putEmp(@RequestBody Emp emp) {
        log.info("修改员工{}", emp);
        empService.putEmp(emp);

        return Result.success();
    }




}
