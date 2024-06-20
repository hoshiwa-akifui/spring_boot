package com.blessingsoftware.controller;

import com.blessingsoftware.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
