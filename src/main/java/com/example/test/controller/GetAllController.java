package com.example.test.controller;

import com.example.test.bean.Course;
import com.example.test.bean.Honor;
import com.example.test.service.GetAllInfo;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
/**
 * 这玩意儿没用到
 * */
@CrossOrigin(origins = "*")
@Controller
public class GetAllController {
    @Autowired
    GetAllInfo getAllInfo;
    @Autowired
    StudentService studentService;

    @ResponseBody
    @PostMapping("/getAll")
    public Map getAll(Integer id){
        return getAllInfo.getAll(id);
    }

    @ResponseBody
    @PostMapping("/getCourse")
    public Map getCourse(Integer id){
        return getAllInfo.getCourse(id);
    }

    @ResponseBody
    @PostMapping("/getSetCourse")
    public List<Course> getSetCourse(){
        return getAllInfo.getSetCourse();
    }

    @ResponseBody
    @PostMapping("/getSetHonor")
    public List<Honor> getSetHonor(){
        return getAllInfo.getSetHonor();
    }

    @ResponseBody
    @PostMapping("/getPractice")
    public Map getPractice(Integer id,String type){
        return getAllInfo.getPractices(id,type);
    }

    @ResponseBody
    @PostMapping("/getStudent")
    public Map getStudent(String num){
        return getAllInfo.getStudent(num);
    }

    @ResponseBody
    @PostMapping("/getStudents")
    public Map getStudents(String numName){
        return getAllInfo.getStudents(numName);
    }

    @ResponseBody
    @PostMapping("/getDaily")
    public Map getDaily(Integer id,String type){
        return getAllInfo.getDaily(id,type);
    }

    @ResponseBody
    @PostMapping("/getHonor")
    public Map getHonor(Integer id){
        return getAllInfo.getHonor(id);
    }

    @ResponseBody
    @PostMapping("/getDayOff")
    public Map getDayOff(Integer id){
        return getAllInfo.getDayOff(id);
    }

    @ResponseBody
    @PostMapping("/getPayment")
    public Map getPayment(Integer id){
        return getAllInfo.getPayment(id);
    }

    @ResponseBody
    @PostMapping("/getNum")
    public Integer getNum(Integer id){
        return studentService.getNById(id);
    }
}
