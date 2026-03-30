package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);


}
