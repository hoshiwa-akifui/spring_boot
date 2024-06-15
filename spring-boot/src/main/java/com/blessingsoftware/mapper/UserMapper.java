package com.blessingsoftware.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
//    List<User> queryUserList();

    List<Map<String, Object>> queryUserList();

    int insertUser(Map<String, Object> map);

    int updateUser(Map<String, Object> map);

    int deleteUser(Map<String, Object> map);
}
