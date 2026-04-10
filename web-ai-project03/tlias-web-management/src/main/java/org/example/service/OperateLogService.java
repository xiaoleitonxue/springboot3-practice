package org.example.service;

import org.example.pojo.OperateLog;
import org.example.pojo.OperateLogQueryParam;
import org.example.pojo.PageResult;
import org.example.pojo.Result;

public interface OperateLogService {

    PageResult<OperateLog> page(OperateLogQueryParam logQueryParam);
}
