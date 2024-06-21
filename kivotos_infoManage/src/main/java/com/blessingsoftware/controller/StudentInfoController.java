package com.blessingsoftware.controller;

import com.blessingsoftware.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @PostMapping("insertStudent")
    public String insertStudent(@RequestParam Map<String, Object> map, HttpSession session){
        return studentInfoService.insertStudent(map, session);
    }

    @PostMapping("updateStudent")
    public String updateStudent(@RequestParam Map<String, Object> map, HttpSession session){
        return studentInfoService.updateStudent(map, session);
    }

    @GetMapping("deleteStudents")
    public String deleteStudents(@RequestParam("ids") String ids, HttpSession session){
        return studentInfoService.deleteStudents(ids, session);
    }
}
