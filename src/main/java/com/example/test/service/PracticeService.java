package com.example.test.service;

import java.util.Map;

public interface PracticeService {
    Map<String,String> addPractice(String studentNum, String description, String practiceTime,
                                   Double hours, String practiceType);
    Map<String, String> updatePractice(String eventId,String studentNum, String description, String practiceTime,
                                       Double hours, String practiceType);
    Map<String, String> deletePractice(String eventId);
    Map getAllPractices(String num);
    Map getOneTypePractices(String num, String type);
}
