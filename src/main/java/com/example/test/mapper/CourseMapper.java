package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    void addCourse(Course course);
    void addSelectedCourse(SelectedCourse selectedCourse);
    int deleteSelectedCourse(SelectedCourse selectedCourse);
    void addTeachersCourse(TeachersCourse teachersCourse);
    void addAbsence(Absence absence);
    void addHomework(Homework homework);
    void addGrades(Grades grades);
    void addEvaluation(Evaluate evaluate);

    List<Course> getCourses();
    Course getCourse(Integer course_id);
    List<Course> getSelectedCourse(Integer id);
    List<Course> getTeachersCourse(Integer id);
    List<Absence> getAbsence(Integer id);
    List<Homework> getHomework(Integer id);
    List<Grades> getGrades(Integer num);
    List<Grades> getAllGrades();
}
