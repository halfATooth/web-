package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.MainPage;
import com.example.test.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    Student getStudent(String num);
    List<Student> getStudents(String numName);
    int addStudent(Student student);
    int initStudent(String num);
    int updateStudent(Student student);
    boolean deleteStuBase(Integer id);
    List<Student> getStudentAll();
    Integer getStuIdByNum(Integer stuNum);
    Integer getNumById(Integer id);
    int initMainPage(String num);
    int updateMainPage(MainPage mainPage);
    MainPage getMainPage(String num);
    String getNameByNum(String num);
}
