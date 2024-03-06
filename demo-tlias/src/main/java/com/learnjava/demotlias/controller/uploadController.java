package com.learnjava.demotlias.controller;

import com.learnjava.demotlias.pojo.Result;
import com.learnjava.demotlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class uploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping
    public Result upload(MultipartFile image) throws IOException {
        log.info(image+"");

        String url = aliOSSUtils.upload(image);
        log.info(url+"");
        return Result.success(url);
    }

}
