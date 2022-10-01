package com.example.test.controller;

import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ResponseBody
    @PostMapping("/addStudent")
    public Map<String,String> getStuInfo(String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone){
        return studentService.addStudent(studentName,studentNum,sex,age,birthday,telephone);
    }

    @ResponseBody
    @PostMapping("/updateStu")
    public Map<String,String> update(String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone){

        return studentService.updateStudent(studentName,studentNum,sex,age,birthday,telephone);
    }

    @ResponseBody
    @RequestMapping("/getStuBaseInfo")
    public Map<String,String> getBase(String num){
        return studentService.getStuBaseInfo(num);
    }

    @ResponseBody
    @RequestMapping("/deleteStuBase")
    public Map<String,String> deleteStu(Integer id){
        return studentService.deleteStu(id);
    }
}