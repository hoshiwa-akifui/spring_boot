package com.blessingsoftware.service;

import com.blessingsoftware.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public List<Map<String, Object>> queryStudents(){
        return studentInfoMapper.queryStudents();
    }

    public String insertStudent(Map<String, Object> map, HttpSession session){

        // 将前端传入的 {学校id，学校name} 分割开来，重新组装放入map里面
        String split[] = map.get("school").toString().split(",");
        map.remove("school");
        map.put("school_id", split[0]);
        map.put("school", split[1]);

        session.setAttribute("msg", studentInfoMapper.insertStudent(map)>=1?"添加成功":"添加失败");
        return "redirect:/studentInfo";
    }
}
