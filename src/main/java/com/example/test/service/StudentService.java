package com.example.test.service;

import java.util.Map;

public interface StudentService {
    Map<String,String> addStudent(String studentName, String studentNum,
       Integer sex, Integer age, String birthday, String telephone);
    Map<String,String> updateStudent(String studentName, String studentNum,
       Integer sex, Integer age, String birthday, String telephone);
    Map<String,String> getStuBaseInfo(String num);
    Map<String,String> deleteStu(Integer id);
    Integer getNById(Integer id);
}
