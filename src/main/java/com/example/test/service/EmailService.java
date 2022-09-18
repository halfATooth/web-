package com.example.test.service;

import java.util.Map;

public interface EmailService {
//    Map<String, Integer> sendEmail(String username, String addressee);
    Map<String,String> sendSimpleEmail(String email, String username);
    Map<String,String> check(String username, Integer code, String email);
}
