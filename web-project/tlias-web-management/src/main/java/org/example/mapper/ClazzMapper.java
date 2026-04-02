package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Clazz;
import org.example.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    @Delete("delete from clazz where id = #{id}")
    void findById(Integer id);

    void add(Clazz clazz);

    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    void updataClazz(Clazz clazz);
}
