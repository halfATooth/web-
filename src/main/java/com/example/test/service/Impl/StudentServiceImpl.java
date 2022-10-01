package com.example.test.service.Impl;

import com.example.test.bean.Student;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Map<String,String> addStudent(String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone) {
        Map<String,String> res = new HashMap<>();

        Student student = new Student();
        student = check(student,studentName,studentNum,sex,age,birthday,telephone);
        try {
            studentMapper.addStudent(student);
            res.put("code","0");
            res.put("msg","添加学生基本信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加学生基本信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> updateStudent(String studentName, String studentNum,
              Integer sex, Integer age, String birthday, String telephone) {
        Map<String, String> res = new HashMap<>();
        try {
        Student student = studentMapper.getStudent(studentNum);
        if(student == null){
            res.put("code","1");
            res.put("msg","更新失败，查无此人");
            return res;
        }else {
            student = check(student,studentName,studentNum,sex,age,birthday,telephone);
        }
            studentMapper.updateStudent(student);
            res.put("code","0");
            res.put("msg","更新成功");
        }catch (Exception e){
            res.put("code","2");
            res.put("msg","更新失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> getStuBaseInfo(String num) {

        Student student = studentMapper.getStudent(num);
        Map<String,String> res = new HashMap<>();
        if(student == null){
            res.put("code","1");
            res.put("msg","查无此人");
            return res;
        }
        res = setInfo(res,student);
        if(student.getSex() == null){
            res.put("sex","0");
        }else res.put("sex",student.getSex()==1?"男":"女");
        return res;
    }

    @Override
    public Map<String, String> deleteStu(Integer id) {
        Map<String, String> res = new HashMap<>();
        try{
            Integer sid = studentMapper.getStuIdByNum(id);
            if(studentMapper.deleteStuBase(sid)){
                res.put("code","0");
                res.put("msg","删除成功");
            }else {
                res.put("code","1");
                res.put("msg","删除失败");
            }
        }catch (Exception e){
            res.put("code","2");
            res.put("msg","本无此人");
        }
        return res;
    }

    @Override
    public Integer getNById(Integer id) {
        Integer num = -1;
        try{
            num = studentMapper.getNumById(id);
        }catch (Exception e){
            num = -1;
            System.out.println("-------------------------");
            System.out.println(e);
        }
        return num;
    }

    private static Student check(Student student,String studentName, String studentNum,
             Integer sex, Integer age, String birthday, String telephone){
        if(studentName != null && !studentName.equals("undefined"))
            student.setStudentName(studentName);
        if(studentNum != null && !studentNum.equals("undefined"))
            student.setStudentNum(studentNum);
        if(age != null)
            student.setAge(age);
        if(sex != null)
            student.setSex(sex);
        if(telephone != null)
            student.setTelephone(telephone);
        if(birthday != null)
            student.setBirthday(birthday);
        return student;
    }
    private static Map<String, String> setInfo(Map<String, String> res,Student student){
//        res.put("id",student.getId()+"");
        res.put("studentName",student.getStudentName());
        res.put("studentNum",student.getStudentNum());
        res.put("age",student.getAge()+"");
        res.put("birthday",student.getBirthday());
        res.put("telephone",student.getTelephone());
        return res;
    }
}
