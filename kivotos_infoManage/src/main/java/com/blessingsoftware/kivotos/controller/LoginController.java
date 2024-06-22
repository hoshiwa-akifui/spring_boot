package com.blessingsoftware.kivotos.controller;

import com.blessingsoftware.kivotos.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String loginCheckTeacher(@RequestParam Map<String, Object> map, HttpSession session) {
        return loginService.checkTeacher(map, session);
    }

    @GetMapping("studentInfo")
    public String studentInfo(){
        return "studentInfo";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @PostMapping("register")
    public String registerTeacher(@RequestParam("avatar") MultipartFile file, @RequestParam Map<String, Object> map, HttpSession session){
        return loginService.registerTeacher(file, map, session);
    }
}
