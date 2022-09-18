package com.example.test.service;

import java.util.Map;

public interface PracticeService {
    Map<String,String> addPractice(Integer id, String description, String practiceTime,
                                   Double hours, String practiceType);
}
