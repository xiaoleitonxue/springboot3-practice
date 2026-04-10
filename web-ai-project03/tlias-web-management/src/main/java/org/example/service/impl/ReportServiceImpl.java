package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.mapper.ReportMapper;
import org.example.pojo.ClazzCountOption;
import org.example.pojo.JobOption;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public JobOption getEmpJobData() {

        List<Map<String, Object>> List = reportMapper.countEmpJobData();

        List<Object> jobList = List.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = List.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return reportMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return reportMapper.countStudentDegreeData();
    }

    @Override
    public ClazzCountOption getStudentCountData() {
        List<Map<String, Object>> List = reportMapper.countStudentCountData();

        List<Object> jobList = List.stream().map(dataMap -> dataMap.get("clazz")).toList();
        List<Object> dataList = List.stream().map(dataMap -> dataMap.get("num")).toList();

        return new ClazzCountOption(jobList, dataList);
    }
}
