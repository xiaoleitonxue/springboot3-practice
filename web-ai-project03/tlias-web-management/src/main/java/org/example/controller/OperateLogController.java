package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.OperateLog;
import org.example.pojo.OperateLogQueryParam;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class OperateLogController {

    @Autowired
    private OperateLogService operatelogService;

    @GetMapping("/page")
    public Result page(OperateLogQueryParam logQueryParam) {
        log.info("分页查询，参数：{}", logQueryParam);
        PageResult<OperateLog> pageResult = operatelogService.page(logQueryParam);
        return Result.success(pageResult);
    }

}
