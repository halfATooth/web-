package com.example.test.controller;

import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "*")
@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Map<String,String> login(String username,String password){
        return userService.handleLogin(username,password);
    }

    @PostMapping("/signup")
    @ResponseBody
    public Map<String,String> signup(String username, String password, String role){
        return userService.addUser(username,password,role);
    }

    @PostMapping("/setEmail")
    @ResponseBody
    public Map<String,String> setEmail(String email, String username){
        return userService.setEmail(email, username);
    }

    @PostMapping("/sendCode")
    @ResponseBody
    public Map<String,String> sendCode(String username){
        return userService.changePwdSend(username);
    }

    @PostMapping("/setPwd")
    @ResponseBody
    public Map<String,String> setPwd(String username, String newPwd, int code){
        return userService.changePwdSet(username,newPwd,code);
    }

}
