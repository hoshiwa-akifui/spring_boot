package com.blessingsoftware.service;

import com.blessingsoftware.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public String checkTeacher(Map<String, Object> map, HttpSession session){
        session.setAttribute("teacher",loginMapper.checkTeacher(map));
        return "redirect:/studentInfo";
    }
}
