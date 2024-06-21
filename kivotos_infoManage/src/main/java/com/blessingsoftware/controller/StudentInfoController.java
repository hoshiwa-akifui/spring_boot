package com.blessingsoftware.controller;

import com.blessingsoftware.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("studentInfo")
    public String studentInfo(){
        return "studentInfo";
    }

    @PostMapping("queryStudents")
    @ResponseBody
    public List<Map<String, Object>> queryStudents(){
        return studentInfoService.queryStudents();
    }
}