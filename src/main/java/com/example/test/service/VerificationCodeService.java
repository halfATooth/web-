package com.example.test.service;

import com.example.test.bean.VerificationCode;

import java.util.Map;

public interface VerificationCodeService {
    Map<String, String> addCode(VerificationCode v);
    Map<String, String> checkCode(VerificationCode v);
}
