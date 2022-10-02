package com.example.test.controller;

import com.example.test.service.CourseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @ResponseBody
    @PostMapping("/addCourse")
    public Map<String,String> course(Integer id, String courseName, String bookName,
                                     String resName, String pptUrl,String teacher, String classTime,
                                     String classPlace, Double point){
        return courseService.addCourse(id,courseName,bookName,resName, pptUrl,teacher,classTime,classPlace,point);
    }

    @ResponseBody
    @PostMapping("/addSelectCourse")
    public Map<String,String> selectedCourse(Integer id, String selectCourseId){
        return courseService.addSelectedCourse(id,selectCourseId);
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

//    @ResponseBody
//    @PostMapping("/addGrades")
//    public Map<String,String> grades(Integer id, Double higher, Double linear, Double discrete, Double physics,
//                                     Double java, Double cpp){
//        return courseService.addGrades( id, higher, linear, discrete,  physics, java, cpp );
//    }

    @ResponseBody
    @PostMapping("/grades")
    public Map<String, String> grade(String data){
        return courseService.addGrades(data);
    }

    @ResponseBody
    @PostMapping("/evaluate")
    public Map<String, String> evaluate(String num, String area, Double points){
        return courseService.addEvaluate(num, area, points);
    }
}
