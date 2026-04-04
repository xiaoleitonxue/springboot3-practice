package org.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();

    @MapKey("clazz")
    List<Map<String, Object>> countStudentCountData();
}
