package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.PageResult;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /*
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {

        Long total = empMapper.count();

        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        return new PageResult<>(total, rows);
    }
    */

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {

        PageHelper.startPage(page, pageSize);

        List<Emp> rows = empMapper.list(name, gender, begin, end);

        Page<Emp> p = (Page<Emp>) rows;

        //Page<Emp> p2 = (Page<Emp>) rows;

        return new PageResult<Emp>(p.getTotal(), p.getResult());

    }
}
