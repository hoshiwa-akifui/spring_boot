package com.blessingsoftware.service;

import com.blessingsoftware.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

//    public List<User> queryUserList(){
//        return userMapper.queryUserList();
//    }

    public List<Map<String, Object>> queryUserList() {
        return userMapper.queryUserList();
    }

    public String insertUser(Map<String, Object> map, HttpSession session) {
        String msg = null;
        int count = userMapper.insertUser(map);
        if (count >= 1) {
            msg = "插入成功！";
        } else {
            msg = "插入失败！";
        }
        session.setAttribute("msg", msg);
        return "redirect:/index";
    }

    public String updateUser(Map<String, Object> map, HttpSession session) {
        String msg = null;
        int count = userMapper.updateUser(map);
        if (count >= 1) {
            msg = "修改成功！";
        } else {
            msg = "修改失败！";
        }
        session.setAttribute("msg", msg);
        return "redirect:/index";
    }

    public String deleteUser(Map<String, Object> map, HttpSession session) {
        String msg = null;
        int count = userMapper.deleteUser(map);
        if (count >= 1) {
            msg = "删除成功！";
        } else {
            msg = "删除失败！";
        }
        session.setAttribute("msg", msg);
        return "redirect:/index";
    }
}
