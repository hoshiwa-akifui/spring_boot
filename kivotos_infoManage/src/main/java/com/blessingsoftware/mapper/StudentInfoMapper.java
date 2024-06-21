package com.blessingsoftware.mapper;

import java.util.*;

public interface StudentInfoMapper {

    List<Map<String, Object>> queryStudents();

    int insertStudent(Map<String, Object> map);
}
