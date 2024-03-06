package com.learnjava.demotlias.controller;

import com.learnjava.demotlias.pojo.Emp;
import com.learnjava.demotlias.pojo.Result;
import com.learnjava.demotlias.service.impl.EmpService;
import com.learnjava.demotlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp e = empService.processLogin(emp);

//        登入成功
        if (e != null) {

            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("userName", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }else {
            return Result.error("error");
        }

//        登入失败



    }

}
