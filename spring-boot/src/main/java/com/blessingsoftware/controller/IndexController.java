package com.blessingsoftware.controller;

import com.blessingsoftware.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

//@RestController
//@ConfigurationProperties(prefix = "student")  //解析一个对象
@Controller
public class IndexController extends BaseController {
    //Servlet controller控制器
    //1:接收值
    //2:调用业务逻辑，然后进行相应的业务操作（在controller是不允许做逻辑判断的）

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

//    @Value("${food}") //解析单一的值
//    private String food;

    // @Autowired   //相当于生成了set/get
    // private Student s;
    //private Config config;

//    private String name;
//    private int age;
//    private String sex;
//    @Autowired
//    private DataSource dataSource;


//    @RequestMapping("reg")
//   // @RequestMapping(value = "reg",method = RequestMethod.GET)
//    public String reg(){
//       // log.info("food:"+food+" name:"+name);
//        //return "food:"+food+" name:"+name;
//       // return "student:"+s.getName();
////        return "datasource:"+dataSource.getClass().getName();
//        log.info("我是get请求的reg");
//        return "reg";
//    }

//1
//    @RequestMapping(value = "reg",method = RequestMethod.POST)
//    public String reg1(HttpServletRequest request){
//        //接收值
////        String username=request.getParameter("username");
////        String password=request.getParameter("password");
////        log.info("username:"+username);
////        log.info("我是post请求的reg");
//        String data[]=getData(new String[]{"username","password"},request);
//        log.info(Arrays.toString(data));
//        return "reg";
//    }
//2
//    @RequestMapping(value = "reg",method = RequestMethod.POST)
//    public String reg1(@RequestParam ("username") String username,@RequestParam ("password") int password){
//        log.info("username:"+username);
//        log.info("password:"+(password+1));
//        return "reg";
//    }

    //3封装
//    @RequestMapping(value = "reg",method = RequestMethod.POST)
//    public String reg1(@ModelAttribute ("user") User u){
//        log.info("username:"+u.getUsername());
//        log.info("password:"+u.getPassword());
//        return "reg";
//    }

    //4封装
//    @RequestMapping(value = "reg",method = RequestMethod.POST)
//    public String reg1(User u){
//        log.info("username:"+u.getUsername());
//        log.info("password:"+u.getPassword());
//        return "reg";
//    }

    //5种Map<K,V>
//    @RequestMapping(value = "reg",method = RequestMethod.POST)
//    public String reg1(HttpServletRequest request){
////        Map<String,Object> allMap=new HashMap<>();
////        Map<String,String[]> map=request.getParameterMap();
////        //log.info("map:"+map.toString());
////        Set<String> set=map.keySet();
////        Iterator<String> it=set.iterator();
////        while(it.hasNext()){
////            String key=it.next();
////            log.info("key:"+key);
////            String value=map.get(key)[0];
////            log.info("value:"+value);
////            allMap.put(key,value);
////        }
//        log.info("allMap:"+getAllParamMap(request));
//        return "reg";
//    }

    //6
//    @RequestMapping(value = "reg",method = RequestMethod.POST)
//    public String reg1(@RequestParam Map<String,Object> map){
//        log.info("allMap:"+map.toString());
//        return "reg";
//    }
//
//    //7特殊 只能用于get请求 要求显示值test?number1=12&number2=15 //rest风格  由?变化成/通常在分页中出现的比较频繁
//    @RequestMapping("test/{number1}/{number2}")
//    public String test(@PathVariable ("number1") String number1,@PathVariable ("number2") String number2){
////        String number1=request.getParameter("number1");
////        String number2=request.getParameter("number2");
//        log.info("number1:"+number1);
//        log.info("number2:"+number2);
//        return null;
//    }

    //转发  重定向
    //默认就是转发  redirect:/URL
    //转发是服务器之间的，重定向是客户端的
    //转发地址栏是不会发生改变的，重定向地址栏是会发生改变的
    //转发是可以带入相关的参数和值的，重定向不行


    //    public String getFood() {
//        return food;
//    }
//
//    public void setFood(String food) {
//        this.food = food;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//转发  重定向
//默认就是转发  redirect:/URL
//转发是服务器之间的，重定向是客户端的
//转发地址栏是不会发生改变的，重定向地址栏是会发生改变的
//转发是可以带入相关的参数和值的，重定向不行
    //login跳转到login登录页面
//    @GetMapping("login")
//    public String login(){
//        return "login";
//    }
//    //验证登录
//    @PostMapping("login")
//    public String login1(@RequestParam Map<String,Object> map, HttpSession session, HttpServletRequest request, HttpServletResponse response){
//        //request.getRequestDispatcher("index.jsp").forward(request,response);
//        //response.sendRedirect("index.jsp");
//        String userAccount=map.get("userAccount").toString();
//        String userPassword=map.get("userPassword").toString();
//        //-------------------取值完成-------------------------
//        if(userAccount.equals("admin")&&userPassword.equals("admin")){
//            session.setAttribute("map",map);//为了让在主页显示信息
//            return "redirect:/success";
//        }else{
//            request.setAttribute("msg","账号或者密码有问题！");
//           return "login";
//        }
//    }
//    @GetMapping("success")
//    public String success(HttpSession session,HttpServletRequest request){
//        if(session.getAttribute("map")==null){
//            request.setAttribute("msg","你没有经过登录！");
//            return "login";
//        }else{
//            return "success";
//        }
//
//    }
    @GetMapping("index")
    public String index(HttpServletRequest request) {
//       List<Map<String,Object>> list=userService.queryUserList();
//       for(Map<String,Object> u:list){
//           log.info("username1:"+u.get("userName"));
//       }
////       for(int i=0;i<list.size();i++){
////        User u=list.get(i);
////          log.info("username2:"+u.getUserAge());
////       }
        request.setAttribute("list", userService.queryUserList());
        return "index";
    }

    @GetMapping("addUser")
    public String addUser() {
        log.info("我会进入到增加的页面");
        return "addUser";
    }

    @PostMapping("addUser")//@RequestParam ("username") String username
    public String addUser1(@RequestParam Map<String, Object> map, HttpSession session) {
        return userService.insertUser(map, session);
    }

    //
    @GetMapping("updateUser")
    public String updateUser(@RequestParam Map<String, Object> map, HttpServletRequest request) {
        request.setAttribute("map", map);
        return "updateUser";
    }

    @PostMapping("updateUser")
    public String updateUser1(@RequestParam Map<String, Object> map, HttpSession session) {
        return userService.updateUser(map, session);
    }

    @GetMapping("deleteUser")
    public String deleteUser(@RequestParam Map<String, Object> map, HttpSession session) {
        return userService.deleteUser(map, session);
    }

    @GetMapping("upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("upload")
    public String upload1(@RequestParam("attr") MultipartFile file, HttpSession session){
//        String fileName = file.getOriginalFilename();
//        log.info("fileName:" + fileName);
//        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
//        filePath=filePath.replaceAll("%20", " ");
//        log.info("filePath:" + filePath);
//
//        filePath+="/"+fileName;
//
//        FileOutputStream fos = null;
//        InputStream is = null;
//        try {
//            fos = new FileOutputStream(filePath);
//            is = file.getInputStream();
//            IOUtils.copy(is, fos);
//        } catch (Exception e) {
//            log.info("有异常");
//        } finally {
//            try {
//                is.close();
//                fos.close();
//            } catch (Exception e) {
//                log.info("有异常");
//            }
//        }
//
//        session.setAttribute("src", "static/"+fileName);
        session.setAttribute("src", uploadAttr(file));
        return "redirect:/info";
    }

    @GetMapping("info")
    public String info() {
        return "info";
    }

}
