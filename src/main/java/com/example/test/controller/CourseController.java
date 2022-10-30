package com.example.test.controller;

import com.example.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    /**这个classTime是前端传过来的json字符串*/
    @ResponseBody
    @PostMapping("/addCourse")
    public Map<String,String> course(Integer id, String courseName, String bookName,
                                     String resName, String pptUrl,String teacher, String classTime,
                                     String classPlace, Double point){
        return courseService.addCourse(id,courseName,bookName,resName, pptUrl,teacher,classTime,classPlace,point);
    }

    @ResponseBody
    @PostMapping("/addSelectCourse")
    public Map<String,String> selectedCourse(Integer num, String selectCourseId){
        return courseService.addSelectedCourse(num,selectCourseId);
    }

    @ResponseBody
    @PostMapping("/deleteSelectCourse")
    public Map<String,String> deleteSelectedCourse(Integer num, String selectCourseId){
        return courseService.deleteSelectedCourse(num,selectCourseId);
    }

    @ResponseBody
    @PostMapping("/addAbsence")
    public Map<String,String> absence(Integer id, String skipCourseName, String skipCourseDate,
                                      String skipCourseTeacher){
        return courseService.addAbsence(id, skipCourseName, skipCourseDate, skipCourseTeacher);
    }

    @ResponseBody
    @PostMapping("/addHomework")
    public Map<String,String> homework(Integer id, String homeworkName, String homeworkDate,
                                       String teacher, String assessment){
        return courseService.addHomework( id, homeworkName, homeworkDate, teacher, assessment );
    }

    /**这个data是前端传过来的json字符串*/
    @ResponseBody
    @PostMapping("/grades")
    public Map<String, String> grade(String data){
        return courseService.addGrades(data);
    }

    @ResponseBody
    @PostMapping("/getGrades")
    public Map getGrade(Integer num){
        return courseService.getGrades(num);
    }

    @ResponseBody
    @PostMapping("/evaluate")
    public Map<String, String> evaluate(String num, String area, Double points){
        return courseService.addEvaluate(num, area, points);
    }

    @ResponseBody
    @PostMapping("/getCourseTable")
    public Map getCourseTable(Integer num){
        return courseService.getCourseTable(num);
    }
}
