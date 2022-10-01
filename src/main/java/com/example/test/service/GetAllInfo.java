package com.example.test.service;

import com.example.test.bean.Course;
import com.example.test.bean.Honor;

import java.util.List;
import java.util.Map;

public interface GetAllInfo {
    Map getStudent(String num);
    Map getStudents(String numName);
    Map getCourse(Integer id);//这是获取学生的学习信息
    List<Course> getSetCourse();//这是获取课程的信息
    List<Honor> getSetHonor();
    Map getPractices(Integer id,String type);
    Map getHonor(Integer id);
    Map getDaily(Integer id, String type);
    Map getDayOff(Integer id);
    Map getPayment(Integer id);
    Map getAll(Integer id);

}
