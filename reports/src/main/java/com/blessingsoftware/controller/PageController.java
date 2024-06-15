package com.blessingsoftware.controller;

import com.blessingsoftware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

    @PostMapping("addUser")
    public String insertUser1(@RequestParam Map<String, Object> map, HttpSession session){
        return userService.insertUser1(map, session);
    }

    @PostMapping("updateUser")
    public String updateUser1(@RequestParam Map<String, Object> map, HttpSession session){
        return userService.updateUser1(map, session);
    }

    @GetMapping("deleteUser")
    public String deleteUse1r(@RequestParam("ids") String ids, HttpSession session){
        return userService.deleteUse1r(ids, session);
    }
}
