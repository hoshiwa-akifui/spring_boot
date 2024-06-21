package com.blessingsoftware.controller;

import com.blessingsoftware.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SchoolInfoController {

    @Autowired
    private SchoolInfoService schoolInfoService;

    @PostMapping("querySchoolNames")
    public List<Map<String, Object>> querySchoolNames(){
        return schoolInfoService.querySchoolNames();
    }
}
