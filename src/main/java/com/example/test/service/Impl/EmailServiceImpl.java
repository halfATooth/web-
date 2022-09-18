package com.example.test.service.Impl;

import com.example.test.bean.VerificationCode;
import com.example.test.service.EmailService;
import com.example.test.service.UserService;
import com.example.test.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private UserService userService;
//    @Override
    private Map<String, Integer> sendEmail(String username, String addressee) {
        Map<String, Integer> res = new HashMap<>();
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("2141619409@qq.com");//发件人
        message.setTo(addressee);//收件人
        message.setSubject("验证码");//主题
        Random r = new Random();
        int code = r.nextInt(1000000);
        message.setText("【web课设】"+username+"您好，"
                +code+"为你的验证码，请在10分钟内完成验证。");//正文
        try{
            mailSender.send(message);
            res.put("code",code);
        }catch (Exception e){
            res.put("code",-1);
        }
        return res;
    }

    @Override
    public Map<String, String> sendSimpleEmail(String email, String username) {
        Map<String,String> res = new HashMap<>();
        Map<String,Integer> ans = sendEmail(username,email);
        long time = System.currentTimeMillis()/1000;
        Integer code = ans.get("code");
        if(code != -1){
            VerificationCode v = new VerificationCode(username,time,code);
            verificationCodeService.addCode(v);
            res.put("code","0");
            res.put("msg","发送成功");
        }else{
            res.put("code","1");
            res.put("msg","发送失败");
        }
        return res;
    }

    @Override
    public Map<String, String> check(String username, Integer code, String email) {
        Map<String,String> ans = verificationCodeService.checkCode(
                new VerificationCode(
                        username,
                        System.currentTimeMillis()/1000,
                        code
                )
        );
        if("0".equals(ans.get("code"))){
            userService.setEmail(email, username);
        }
        return ans;
    }
}
