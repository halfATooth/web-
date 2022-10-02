package com.example.test.controller;

import com.example.test.bean.MainPage;
import com.example.test.mapper.StudentMapper;
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
    @Autowired
    StudentMapper studentMapper;

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

    @ResponseBody
    @RequestMapping("/getMainPage")
    public Map<String, String> getMainPage(String num){
        return studentService.getMainPage(num);
    }

    @ResponseBody
    @RequestMapping("/addMainPage")
    public Map<String, String> addMainPage(String num, String resume, String blog,
                                           String researchArea, String courses, String article){
        return studentService.addInfo(num, resume,blog,researchArea,courses,article);
    }
}