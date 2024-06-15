package com.blessingsoftware.service;

import com.blessingsoftware.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public List<Map<String, Object>> queryList() {
        return adminMapper.queryList();
    }

    public String insertAdmin(Map<String, Object> map, HttpServletRequest request, HttpSession session){
        map.put("admin_last_login_ip", request.getRemoteAddr());
        String msg = adminMapper.insertAdmin(map) >= 1 ? "新增成功" : "新增失败";
        session.setAttribute("msg", msg);
        return "redirect:/admin";
    }

    public String updateAdmin(Map<String, Object> map, HttpSession session){
        String msg = adminMapper.updateAdmin(map) >= 1 ? "修改成功" : "修改失败";
        session.setAttribute("msg", msg);
        return "redirect:/admin";
    }

    public String deleteAdmin(String ids, HttpSession session){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<ids.split(",").length; i++){
            list.add(Integer.parseInt(ids.split(",")[i]));
        }
        session.setAttribute("msg", adminMapper.deleteAdmin(list) >= 1 ? "删除成功" : "删除失败");
        return "redirect:/admin";
    }
}
