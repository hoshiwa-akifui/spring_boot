package com.blessingsoftware.service;

import com.blessingsoftware.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public List<Map<String, Object>> queryList(){
        return userMapper.queryList();
    }

    // 添加
    public String insertUser(Map<String, Object> map){
        return userMapper.insertUser(map)>=1?"添加成功":"添加失败";
    }

    // 修改
    public String updateUser(Map<String, Object> map){
        return userMapper.updateUser(map)>=1?"修改成功":"修改失败";
    }
    // 删除
    public String deleteUser(Map<String, Object> map){
        return userMapper.deleteUser(map)>=1?"删除成功":"删除失败";
    }

    public String insertUser1(Map<String, Object> map, HttpSession session){
        session.setAttribute("msg", userMapper.insertUser(map) >= 1 ? "新增成功" : "新增失败");
        return "redirect:/table";
    }

    public String updateUser1(Map<String, Object> map, HttpSession session){
        session.setAttribute("msg", userMapper.updateUser(map) >= 1 ? "修改成功" : "修改失败");
        return "redirect:/table";
    }

    public String deleteUse1r(String ids, HttpSession session){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<ids.split(",").length; i++){
            list.add(Integer.parseInt(ids.split(",")[i]));
        }
        session.setAttribute("msg", userMapper.deleteMore(list) >= 1 ? "删除成功" : "删除失败");
        return "redirect:/table";
    }

}
