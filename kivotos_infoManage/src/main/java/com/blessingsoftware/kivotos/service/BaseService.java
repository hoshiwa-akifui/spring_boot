package com.blessingsoftware.kivotos.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class BaseService {

    public String encryptFileName(String fileName){
        return UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
    }

    public String uploadAvatar(MultipartFile file){
        String fileName = encryptFileName(file.getOriginalFilename());
        String path = "E:\\Program Files\\projects\\spring_boot\\kivotos_infoManage\\src\\main\\resources\\templates\\static\\img\\"
                +fileName;
        path = path.replace("%20", " ");

        FileOutputStream fos = null;
        InputStream is = null;

        try {
            fos = new FileOutputStream(path);
            is = file.getInputStream();
            IOUtils.copy(is, fos);
        } catch (Exception e) {
            System.out.println("写入文件异常");
        } finally {
            try {
                is.close();
                fos.close();
            } catch (IOException e) {
                System.out.println("关闭异常");
            }
        }

        return "static/img/" + fileName;
    }
}
