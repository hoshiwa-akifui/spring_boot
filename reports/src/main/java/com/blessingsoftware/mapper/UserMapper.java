package com.blessingsoftware.mapper;

import java.util.*;

public interface UserMapper {

    List<Map<String, Object>> queryList();

    int insertUser(Map<String, Object> map);

    int updateUser(Map<String, Object> map);

    int deleteUser(Map<String, Object> map);

    // 可删除任意个
    int deleteMore(List<Integer> ids);
}
