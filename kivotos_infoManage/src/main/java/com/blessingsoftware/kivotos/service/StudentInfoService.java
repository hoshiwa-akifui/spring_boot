package com.blessingsoftware.kivotos.service;

import com.blessingsoftware.kivotos.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    public String updateStudent(Map<String, Object> map, HttpSession session){

        // 将前端传入的 {学校id，学校name} 分割开来，重新组装放入map里面
        String split[] = map.get("school").toString().split(",");
        map.remove("school");
        map.put("school_id", split[0]);
        map.put("school", split[1]);

        session.setAttribute("msg", studentInfoMapper.updateStudent(map)>=1?"修改成功":"修改失败");
        return "redirect:/studentInfo";
    }

    public String deleteStudents(String ids, HttpSession session){
        List<Integer> idList = new ArrayList<>();
        for(int i=0;i<ids.split(",").length;i++){
            idList.add(Integer.parseInt(ids.split(",")[i]));
        }
        session.setAttribute("msg", studentInfoMapper.deleteStudents(idList)>=1?"删除成功":"删除失败");
        return "redirect:/studentInfo";
    }
}
