package com.example.test.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface BasicInfoService {
    Map<String,String> addInfo(String resume, MultipartFile img, String blog,
                               String researchArea, String courses, String article);
}
