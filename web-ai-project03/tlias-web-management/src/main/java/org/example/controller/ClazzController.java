package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.example.pojo.Clazz;
import org.example.pojo.ClazzQueryParam;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result findAll(ClazzQueryParam clazzQueryParam) {
        log.info("查询参数: {}", clazzQueryParam);
        PageResult<Clazz> result = clazzService.findAll(clazzQueryParam);
        return Result.success(result);
    }

    @DeleteMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        log.info("删除id数据: {}", id);
        clazzService.findById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("添加数据: {}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询id数据: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("更新数据: {}", clazz);
        clazzService.updataClazz(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list() {
        log.info("查询列表");
        return Result.success(clazzService.list());
    }

}
