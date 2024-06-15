package com.blessingsoftware.controller;

import com.blessingsoftware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public List<Map<String, Object>> queryList(){
        return userService.queryList();
    }

    @RequestMapping(value = "insert", produces = "text/plain; charset=UTF-8") // ?user_name=keqing&user_age=18
    public String insertUser(@RequestParam Map<String, Object> map){
        return userService.insertUser(map);
    }

    @RequestMapping(value = "update", produces = "text/plain; charset=UTF-8") /* ?user_id=3&user_name=keqing&user_age=18 */
    public String updateUser(@RequestParam Map<String, Object> map){
        return userService.updateUser(map);
    }
    @RequestMapping(value = "delete", produces = "text/plain; charset=UTF-8") // ?user_id=8
    public String deleteUser(@RequestParam Map<String, Object> map){
        return userService.deleteUser(map);
    }
}
