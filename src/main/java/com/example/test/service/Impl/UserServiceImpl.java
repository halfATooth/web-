package com.example.test.service.Impl;

import com.example.test.bean.*;
import com.example.test.mapper.StudentMapper;
import com.example.test.mapper.UserMapper;
import com.example.test.mapper.VerificationCodeMapper;
import com.example.test.service.EmailService;
import com.example.test.service.UserService;
import com.example.test.service.VerificationCodeService;
import com.example.test.util.JwtUitls;
import com.example.test.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private VerificationCodeService codeService;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public String getName(Integer id) {
        return userMapper.getNameById(id);
    }

    @Override
    public String getRole(Integer id) {
        return userMapper.getRole(id);
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
    public Map<String,String> addUser(String num, String password, String role) {
        User user = new User();
        user.setUsername(num);
        user.setPassword(SecurityUtils.encodePassword(password));
        user.setRole(role);
        Map<String,String> res = new HashMap<>();
        try {
            userMapper.addUser(user);
            studentMapper.initStudent(num);
            studentMapper.initMainPage(num);
            userMapper.initLike(num);
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

    @Override
    public Map<String, String> like(String num) {
        Map<String,String> res = new HashMap<>();
        try{
            int now = userMapper.getLikes(num);
            userMapper.addLike(new Like(num,now+1));
            res.put("code","0");
            res.put("msg","点赞成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","点赞失败");
        }
        return res;
    }

    @Override
    public Map<String, String> addFollow(String num, String follow) {
        Map<String,String> res = new HashMap<>();
        try{
            userMapper.addFollow(new Follow(num,follow));
            res.put("code","0");
            res.put("msg","关注成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","关注失败");
        }
        return res;
    }

    @Override
    public Map<String, String> addComments(String upNum, String tourNum, String content) {
        Map<String,String> res = new HashMap<>();
        try{
            userMapper.addComments(new Comments(upNum,tourNum,content));
            res.put("code","0");
            res.put("msg","评论成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","评论失败");
        }
        return res;
    }

    @Override
    public Map getMultiEvaluation(String num) {
        Map res = new HashMap();
        try{
            Integer likes = userMapper.getLikes(num);
            res.put("likes",likes);
            res.put("followers",getFollowers(num));
            res.put("idols",getIdols(num));
            res.put("comments",getComments(num));
            res.put("code","0");
            res.put("msg","获取成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","获取失败");
        }
        return res;
    }
    private List<Map<String,String>> getComments(String num){
        List<Comments> rawComments = userMapper.getComments(num);
        List<String> touristNums = new ArrayList<>();
        for(Comments comments : rawComments){
            touristNums.add(comments.getTouristNum());
        }
        List<Map<String,String>> commentsWithNames = getInfosByNums(touristNums);
        for(int i=0;i< rawComments.size();i++){
            String content = rawComments.get(i).getContent();
            commentsWithNames.get(i).put("comments",content);
        }
        return commentsWithNames;
    }
    private List<Map<String,String>> getFollowers(String num){
        List<String> followerNum = userMapper.getFollowers(num);
        return getInfosByNums(followerNum);
    }
    private List<Map<String,String>> getIdols(String num){
        List<String> idolNum = userMapper.getIdols(num);
        return getInfosByNums(idolNum);
    }
    private List<Map<String,String>> getInfosByNums(List<String> nums){
        List<Map<String,String>> people = new ArrayList<>();
        for(String n : nums){
            Map<String,String> person = new HashMap<>();
            person.put("number",n);
            String name = studentMapper.getNameByNum(n);
            person.put("name",name);
            people.add(person);
        }
        return people;
    }
}
