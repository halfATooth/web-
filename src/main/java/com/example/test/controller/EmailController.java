package com.example.test.controller;

import com.example.test.bean.VerificationCode;
import com.example.test.service.EmailService;
import com.example.test.service.UserService;
import com.example.test.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/send")
    public Map<String,String> sendEmail(String email, String username){
        return emailService.sendSimpleEmail(email,username);
    }

    @ResponseBody
    @PostMapping("/check")
    public Map<String,String> check(String username, Integer code, String email){
        return emailService.check(username,code,email);
    }
}
