package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.StudentMapper;
import org.example.pojo.PageResult;
import org.example.pojo.Student;
import org.example.pojo.StudentQueryParam;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public PageResult<Student> findAll(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        List<Student> rows = studentMapper.findAll(studentQueryParam);

        Page<Student> p = (Page<Student>) rows;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(List<Integer> ids) {

        studentMapper.deleteById(ids);
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());

        studentMapper.add(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateViolation(Integer id, String degree) {
        Student student = studentMapper.getById(id);
        if (student != null) {
            student.setUpdateTime(LocalDateTime.now());
            update(student);
            studentMapper.updateViolation(id, degree);
        }
    }
}