package com.blessingsoftware.kivotos.mapper;

import java.util.*;

public interface StudentInfoMapper {

    List<Map<String, Object>> queryStudents();

    int insertStudent(Map<String, Object> map);

    int updateStudent(Map<String, Object> map);

    int deleteStudents(List<Integer> ids);
}
