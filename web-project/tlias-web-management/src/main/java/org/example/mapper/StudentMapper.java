package org.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;

import java.util.List;

public interface StudentMapper {

    List<Student> findAll(StudentQueryParam studentQueryParam);


    void deleteById(List<Integer> ids);

    void add(Student student);

    @Select("Select * from student where id = #{id}")
    Student getById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, String degree);
}
