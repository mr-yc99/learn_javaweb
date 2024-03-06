package com.learnjava.demotlias.controller;

import com.learnjava.demotlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("test")
public class testController {

    @PostMapping
    public void test(String name, String address) {
        System.out.println(name + address);





    }
}
