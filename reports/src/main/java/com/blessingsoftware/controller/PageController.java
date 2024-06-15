package com.blessingsoftware.controller;

import com.blessingsoftware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("table")
    public String table(HttpSession session) {
        session.setAttribute("users", userService.queryList());
        return "table";
    }
}
