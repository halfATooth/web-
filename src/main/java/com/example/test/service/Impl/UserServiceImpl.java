package com.example.test.service.Impl;

import com.example.test.bean.User;
import com.example.test.bean.VerificationCode;
import com.example.test.mapper.UserMapper;
import com.example.test.mapper.VerificationCodeMapper;
import com.example.test.service.EmailService;
import com.example.test.service.UserService;
import com.example.test.service.VerificationCodeService;
import com.example.test.util.JwtUitls;
import com.example.test.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private VerificationCodeService codeService;
    @Override
    public String getName(Integer id) {
        return userMapper.getNameById(id);
    }

    @Override
    public Map<String, String> setEmail(String email, String username) {
        Map<String,String> res = new HashMap<>();

        int i = userMapper.setEmail(email, username);
        if(i == 0) {
            res.put("code","1");
            res.put("msg","邮箱更新失败，多半是用户名错了");
        }else{
            res.put("code","0");
            res.put("msg","邮箱更新成功");
        }
        return res;
    }


    @Override
    public Map<String,String> addUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(SecurityUtils.encodePassword(password));
        user.setRole(role);
        Map<String,String> res = new HashMap<>();
        try {
            userMapper.addUser(user);
            res.put("code","0");
            res.put("msg","注册成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加失败，用户名已存在");
        }
        return res;
    }

    @Override
    public Map<String, String> handleLogin(String username, String password) {
        Map<String,String> responseData = new HashMap<>();
        Integer id = userMapper.getIdByName(username);
        if(SecurityUtils.matchesPassword(password, userMapper.getPwdById(id))){
            JwtUitls jwtUitls = new JwtUitls();
            String token = jwtUitls.createToken(id+"",username);
            responseData.put("code","0");
            responseData.put("msg","登录成功");
            responseData.put("token",token);
        }else {
            responseData.put("code","1");
            responseData.put("msg","登录失败");
        }
        return responseData;
    }

    @Override
    public Map<String, String> changePwdSend(String username) {
        Map<String,String> res = new HashMap<>();
        String ad = userMapper.getEmail(username);
        if(ad == null){
            res.put("code","11");
            res.put("msg","未绑定邮箱，无法修改密码");
        }else {
            res = emailService.sendSimpleEmail(ad,username);
        }
        return res;
    }

    @Override
    public Map<String, String> changePwdSet(String username, String password, int code) {
        Map<String,String> res = new HashMap<>();
        VerificationCode v_code = new VerificationCode(username,
                System.currentTimeMillis()/1000,code);
        Map<String,String> ans = codeService.checkCode(v_code);
        if("0".equals(ans.get("code"))){
            User user = new User();
            user.setPassword(SecurityUtils.encodePassword(password));
            user.setUsername(username);
            int i = userMapper.changePwd(user);
            if(i == 1){
                res.put("code","0");
                res.put("msg","修改密码成功");
            }else{
                res.put("code","1");
                res.put("msg","验证通过，但更新失败");
            }
        }else {
            res.put("code","2");
            res.put("msg","验证未通过");
            res.put("detail",ans.get("msg"));
        }
        return res;
    }
}
