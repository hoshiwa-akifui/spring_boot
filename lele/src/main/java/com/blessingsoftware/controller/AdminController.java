package com.blessingsoftware.controller;

import com.blessingsoftware.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("admin")
    public String admin(HttpServletRequest request) {
        request.setAttribute("admins", adminService.queryList());
        return "admin";
    }

    @PostMapping("addAdmin")
    public String addAdmin(@RequestParam Map<String, Object> map, HttpServletRequest request, HttpSession session){
        return adminService.insertAdmin(map, request, session);
    }

    @PostMapping("updateAdmin")
    public String updateAdmin(@RequestParam Map<String, Object> map, HttpSession session){
        return adminService.updateAdmin(map, session);
    }

    @GetMapping("deleteAdmin")
    public String deleteAdmin(@RequestParam("ids") String ids, HttpSession session){
        return adminService.deleteAdmin(ids, session);
    }
}
