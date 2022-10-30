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
    public Map<String,String> login(String num,String password){
        return userService.handleLogin(num,password);
    }

    @PostMapping("/signup")
    @ResponseBody
    public Map<String,String> signup(String num, String password, String role){
        return userService.addUser(num,password,role);
    }

    @PostMapping("/setEmail")
    @ResponseBody
    public Map<String,String> setEmail(String email, String num){
        return userService.setEmail(email, num);
    }

    @PostMapping("/sendCode")
    @ResponseBody
    public Map<String,String> sendCode(String num){
        return userService.changePwdSend(num);
    }

    @PostMapping("/setPwd")
    @ResponseBody
    public Map<String,String> setPwd(String num, String newPwd, int code){
        return userService.changePwdSet(num,newPwd,code);
    }

    @PostMapping("/like")
    @ResponseBody
    public Map<String,String> like(String num){
        return userService.like(num);
    }

    @PostMapping("/follow")
    @ResponseBody
    public Map<String,String> follow(String num, String followed){
        return userService.addFollow(num,followed);
    }

    @PostMapping("/comment")
    @ResponseBody
    public Map<String,String> comment(String up, String tourist, String comments){
        return userService.addComments(up,tourist,comments);
    }

    @PostMapping("/getEvaluation")
    @ResponseBody
    public Map getEvaluation(String num){
        return userService.getMultiEvaluation(num);
    }
}
