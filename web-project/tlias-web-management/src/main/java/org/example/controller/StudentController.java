package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result findAll(StudentQueryParam studentQueryParam){
        log.info("查询列表");
        PageResult<Student> result = studentService.findAll(studentQueryParam);
        return Result.success(result);
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable String ids){
        log.info("删除id数据: {}", ids);
        List<Integer> idlist = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        studentService.deleteById(idlist);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加数据: {}", student);
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询id数据: {}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改数据: {}", student);
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{degree}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable String degree){
        log.info("修改数据: {}", id);
        studentService.updateViolation(id, degree);
        return Result.success();
    }

}
