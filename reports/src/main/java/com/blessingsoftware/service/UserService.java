package com.blessingsoftware.service;

import com.blessingsoftware.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
