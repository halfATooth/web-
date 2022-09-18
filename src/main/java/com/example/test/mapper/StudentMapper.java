package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    Student getStudent(Integer id);
    List<Student> getStudents(String numName);
    int addStudent(Student student);
    int updateStudent(Student student);
    boolean deleteStuBase(Integer id);
    List<Student> getStudentAll();
    Integer getStuIdByNum(Integer stuNum);
    Integer getNumById(Integer id);
}
