package com.blessingsoftware.controller;

import com.blessingsoftware.config.TeacherConfig;
import com.blessingsoftware.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class IndexController {

//    @RequestMapping(value = "index", produces = "text/plain; charset=UTF-8")
//    public String index() {
//        return "谢劲锋-男-20岁";
//    }

    // 1
//    @Value("${teacher.id}")
//    private String teacherId;
//    @Value("${teacher.name}")
//    private String teacherName;
//    @Value("${teacher.age}")
//    private String teacherAge;
//    @Value("${teacher.sex}")
//    private String teacherSex;
//    @RequestMapping("index")
//    public String index() {
//        return "teacherId: "+teacherId
//                +"\nteacherName: "+teacherName
//                +"\nteacherAge: "+teacherAge
//                +"\nteacherSex: "+teacherSex;
//    }
    // 2
//    @Autowired
//    private Teacher teacher;
//    @RequestMapping("index")
//    public String index() {
//        return "teacher: "+teacher.toString();
//    }
    // 3
//    @Autowired
//    private TeacherConfig teacherConfig;
//    @RequestMapping("index")
//    public String index() {
//        return "teacher: "+teacherConfig.getTeacher();
//    }

    @Autowired
    private DataSource dataSource;
    @RequestMapping("index")
    public String index() {
        return "dataSource: "+dataSource.getClass().getName();
    }
}
