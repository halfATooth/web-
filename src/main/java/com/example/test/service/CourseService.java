package com.example.test.service;

import com.example.test.bean.Course;

import java.util.Map;

public interface CourseService {
    Map<String,String> addCourse(Integer id,String courseName,String bookName,String resName,String pptUrl,
        String teacher, String classTime, String classPlace, Double point);

    Map<String,String> addSelectedCourse(Integer id, String selectCourseId);

    Map<String,String> addAbsence(Integer id, String skipCourseName, String skipCourseDate, String skipCourseTeacher);

    Map<String,String> addHomework(Integer id, String homeworkName, String homeworkDate, String teacher,
                                   String assessment);

    Map<String,String> addGrades(String data);
}
