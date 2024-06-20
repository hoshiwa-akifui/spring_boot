package com.blessingsoftware.service;

import com.blessingsoftware.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public List<Map<String, Object>> queryStudents(){
        return studentInfoMapper.queryStudents();
    }
}
