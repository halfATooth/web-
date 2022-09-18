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
              Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
              String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
              String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
              Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
              String mName,String mPhone,String mWorkplace){
        return studentService.addStudent(studentName,studentNum,sex,age,birthday,telephone,pName,pPosition,
                pEnterDate, pGraduateDate, jName, jPosition, jEnterDate,
                jGraduateDate, sName, sPosition, sEnterDate, sGraduateDate,
                familyNum, familyPosition, fName, fPhone, fWorkplace,
                mName, mPhone, mWorkplace);
    }

    @ResponseBody
    @PostMapping("/updateStu")
    public Map<String,String> update(Integer id,String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
              String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
              String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
              Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
              String mName,String mPhone,String mWorkplace){

        return studentService.updateStudent(id,studentName,studentNum,sex,age,birthday,telephone,pName,pPosition,
                pEnterDate, pGraduateDate, jName, jPosition, jEnterDate,
                jGraduateDate, sName, sPosition, sEnterDate, sGraduateDate,
                familyNum, familyPosition, fName, fPhone, fWorkplace,
                mName, mPhone, mWorkplace);
    }

    @ResponseBody
    @RequestMapping("/getStuBaseInfo")
    public Map<String,String> getBase(Integer id){
        return studentService.getStuBaseInfo(id);
    }

    @ResponseBody
    @RequestMapping("/deleteStuBase")
    public Map<String,String> deleteStu(Integer id){
        return studentService.deleteStu(id);
    }
}