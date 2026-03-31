package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name,Integer age,  MultipartFile file) throws IOException {
        log.info("上传文件，参数：{},{},{}", name, age, file);

        String newFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        file.transferTo(new File("D:/images/" + newFileName));
        return Result.success();
    }


}
