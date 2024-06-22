package com.blessingsoftware.kivotos.service;

import com.blessingsoftware.kivotos.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class LoginService extends BaseService {

    @Autowired
    private LoginMapper loginMapper;

    public String checkTeacher(Map<String, Object> map, HttpSession session){
        session.setAttribute("teacher",loginMapper.checkTeacher(map));
        return "redirect:/studentInfo";
    }

    public String registerTeacher(MultipartFile file, Map<String, Object> map, HttpSession session){

        // 将头像的地址放入map当中
        map.put("avatar", uploadAvatar(file));

        session.setAttribute("msg",loginMapper.registerTeacher(map)>=1?"注册成功":"注册失败");
        return "redirect:/login";
    }
}
