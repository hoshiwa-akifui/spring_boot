package com.blessingsoftware.mapper;

import java.util.*;

public interface AdminMapper {

    List<Map<String, Object>> queryList();

    int insertAdmin(Map<String, Object> map);

    int updateAdmin(Map<String, Object> map);

    int deleteAdmin(List<Integer> ids);
}
