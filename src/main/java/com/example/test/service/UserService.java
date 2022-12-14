package com.example.test.service;

import java.util.Map;

public interface UserService {
    String getName(Integer id);
    String getRole(Integer id);
    Map<String,String> setEmail(String email, String username);
    Map<String,String> addUser(String username, String password, String role);
    Map<String,String> handleLogin(String username, String password);
    Map<String,String> changePwdSend(String username);
    Map<String,String> changePwdSet(String username, String password, int code);
    Map<String,String> like(String num);
    Map<String,String> addFollow(String num, String follow);
    Map<String,String> addComments(String upNum,String tourNum,String content);
    Map getMultiEvaluation(String num);
}
