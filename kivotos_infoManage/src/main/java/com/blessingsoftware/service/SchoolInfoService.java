package com.blessingsoftware.service;

import com.blessingsoftware.mapper.SchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchoolInfoService {

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    public List<Map<String, Object>> querySchoolNames(){
        return schoolInfoMapper.querySchoolNames();
    }
}
