package com.learnjava.controller;

import com.learnjava.pojo.Result;
import com.learnjava.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    @RequestMapping("/simpleParm")
    public Result simpleParam(String name, Integer age) {
        System.out.println(name + "+" + age);
        return Result.success("simpleParam");


    }

    @RequestMapping("/simplePojo")
    public Result simplePojo(User user){
        System.out.println(user);
        return Result.success("simplePojo");
    }

    @RequestMapping("/complexPojo")
    public Result complexPojo(User user){
        System.out.println(user);
        return Result.success(user);
    }

    @RequestMapping("/arrayParamPojo")
    public String arrayParamPojo(String[] hobby){

        System.out.println(Arrays.toString(hobby));
        return "200 OK";
    }

    @RequestMapping("/listParamPojo")
    public String listParamPojo(@RequestParam List<String> hobby){

        System.out.println(hobby);
        return "200 OK";
    }

    @RequestMapping("/dateParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime upDateTime){
        System.out.println(upDateTime);
        return "200 OK";
    }

    @RequestMapping("/jsonParam")
    public Result jsonParam(@RequestBody User user){
        System.out.println(user);
        return Result.success(user);
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id + "&" + name);
        return "path 200 OK";
    }




}
