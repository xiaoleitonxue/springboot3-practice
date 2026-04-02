package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.ClazzMapper;
import org.example.pojo.*;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> rows = clazzMapper.findAll(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) rows;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public void findById(Integer id) {
        clazzMapper.findById(id);
    }

    @Override
    public void add(Clazz clazz) {
            clazz.setCreateTime(LocalDateTime.now());
            clazz.setUpdateTime(LocalDateTime.now());
            clazzMapper.add(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void updataClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updataClazz(clazz);
    }
}
