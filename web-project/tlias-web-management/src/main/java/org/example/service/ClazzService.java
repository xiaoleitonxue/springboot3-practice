package org.example.service;

import org.example.pojo.Clazz;
import org.example.pojo.ClazzQueryParam;
import org.example.pojo.PageResult;

public interface ClazzService {
    PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    void findById(Integer id);

    void add(Clazz clazz);

    Clazz getById(Integer id);

    void updataClazz(Clazz clazz);
}
