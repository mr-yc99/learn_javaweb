package com.learnjava.demotlias.controller;

import com.learnjava.demotlias.pojo.Dept;
import com.learnjava.demotlias.pojo.Result;
import com.learnjava.demotlias.service.DeptServiceImpl;
import com.learnjava.demotlias.service.impl.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;


    //LoggerFactoryLoggerFactoryLoggerFactory要复习一下
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result getDept(){
        log.info("getDept方法：查询全部部门日志");
        
        List<Dept> deptList = deptService.getDept();

        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result DeleteByID (@PathVariable Integer id){
        log.info("DelelteByID, 通过ID:{}删除部门", id);

        deptService.deleteByID(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept){

        log.info("addDept, 添加了部门名：{}", dept.getName());

        deptService.addDept(dept);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getByID(@PathVariable Integer id){
        log.info("getByID, 通过id查询部门：{}", id);

        deptService.getByID(id);

        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("update, 修改部门：{}", dept.getId());

        deptService.update(dept);

        return Result.success();
    }




}
