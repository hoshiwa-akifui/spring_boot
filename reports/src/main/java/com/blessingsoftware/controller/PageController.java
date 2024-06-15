package com.blessingsoftware.controller;

import com.blessingsoftware.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("table")
    public String table(HttpSession session) {
        session.setAttribute("users", userService.queryList());
        return "table";
    }

    @PostMapping("addUser")
    public String insertUser1(@RequestParam Map<String, Object> map, HttpSession session){
        return userService.insertUser1(map, session);
    }

    @PostMapping("updateUser")
    public String updateUser1(@RequestParam Map<String, Object> map, HttpSession session){
        return userService.updateUser1(map, session);
    }

    @GetMapping("deleteUser")
    public String deleteUse1r(@RequestParam("ids") String ids, HttpSession session){
        return userService.deleteUse1r(ids, session);
    }

    @PostMapping("upload")
    public String upload(@RequestParam("attrs") List<MultipartFile> files, HttpSession session){
        List<String> urls = new ArrayList<>();
        for(int i=0;i<files.size();i++){
            String of = files.get(i).getOriginalFilename();
            of = UUID.randomUUID() + of.substring(of.lastIndexOf("."));
            String path = "E:\\Program Files\\projects\\spring_boot\\reports\\img";
            path=path.replaceAll("%20", " ")+"/"+of;

            FileOutputStream fos = null;
            InputStream is = null;
            try {
                fos=new FileOutputStream(path);
                is=files.get(i).getInputStream();
                IOUtils.copy(is, fos);
            } catch (Exception e) {
                System.out.println("出现异常");
            }finally {
                try {
                    is.close();
                    fos.close();
                } catch (IOException e) {
                    System.out.println("关闭异常");
                }
            }
            urls.add("static/"+of);
        }
        session.setAttribute("imgs", urls);
        return "redirect:/info";
    }

    @GetMapping("info")
    public String info(){
        return "info";
    }

    @GetMapping("video")
    public String video(){
        return "video";
    }

    @GetMapping("videoInfo")
    public String videoInfo(){
        return "videoInfo";
    }

    @PostMapping("uv")
    public String uv(@RequestParam("attr") MultipartFile file, HttpSession session){
        String of = file.getOriginalFilename();
        of = UUID.randomUUID() + of.substring(of.lastIndexOf("."));
        String path = "E:\\Program Files\\projects\\spring_boot\\reports\\img";
        path=path.replaceAll("%20", " ")+"/"+of;

        FileOutputStream fos = null;
        InputStream is = null;
        try {
            fos=new FileOutputStream(path);
            is=file.getInputStream();
            IOUtils.copy(is, fos);
        } catch (Exception e) {
            System.out.println("出现异常");
        }finally {
            try {
                is.close();
                fos.close();
            } catch (IOException e) {
                System.out.println("关闭异常");
            }
        }
        session.setAttribute("v", "static/"+of);
        return "redirect:/videoInfo";
    }
}
