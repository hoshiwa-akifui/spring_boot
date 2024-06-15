package com.blessingsoftware.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

public class BaseController {

    //String username=request.getParameter("username");

    //循环接受值
    public String[] getData(String data[], HttpServletRequest request) {
        String s[] = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            s[i] = request.getParameter(data[i]);
        }
        return s;
    }

    //得到前端的所有参数和值，通过此方法自动转换为map形式
    public Map<String, Object> getAllParamMap(HttpServletRequest request) {
        Map<String, Object> allMap = new HashMap<>();
        Map<String, String[]> map = request.getParameterMap();
        //log.info("map:"+map.toString());
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            // log.info("key:"+key);
            String value = map.get(key)[0];
            // log.info("value:"+value);
            allMap.put(key, value);
        }
        return allMap;
    }

    public String getNewName(String oldName){
        return UUID.randomUUID()+oldName.substring(oldName.lastIndexOf('.'));
    }

    public String uploadAttr(@RequestParam("attr") MultipartFile file){
        String fileName = getNewName(file.getOriginalFilename());
        // String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String filePath = "E:\\Program Files\\projects\\spring-boot\\img";

        filePath=filePath.replaceAll("%20", " ");
        filePath+="/"+fileName;

        FileOutputStream fos = null;
        InputStream is = null;
        try {
            fos = new FileOutputStream(filePath);
            is = file.getInputStream();
            IOUtils.copy(is, fos);
        } catch (Exception e) {

        } finally {
            try {
                is.close();
                fos.close();
            } catch (Exception e) {

            }
        }

        return "static/"+fileName;
    }
}
