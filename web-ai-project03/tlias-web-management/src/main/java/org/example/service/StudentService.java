package org.example.service;

import org.example.pojo.PageResult;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    PageResult<Student> findAll(StudentQueryParam studentQueryParam);


    void deleteById(List<Integer> ids);

    void add(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, String degree);
}
