package com.blessingsoftware.kivotos.mapper;

import java.util.*;

public interface LoginMapper {

    Map<String, Object> checkTeacher(Map<String, Object> map);

    int registerTeacher(Map<String, Object> map);
}
