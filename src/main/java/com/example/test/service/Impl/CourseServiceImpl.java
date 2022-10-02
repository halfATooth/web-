package com.example.test.service.Impl;

import com.example.test.bean.*;
import com.example.test.mapper.CourseMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.CourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
    private Integer getIdByN(Integer num){
        return studentMapper.getStuIdByNum(num);
    }
    @Override
    public Map<String, String> addCourse(Integer id, String courseName, String bookName,String resName,
                                         String pptUrl,String teacher, String classTime,
                                         String classPlace, Double point) {
        Map<String, String> res = new HashMap<>();
        try {
            Course course = new Course(id, courseName,  bookName, resName, pptUrl, teacher,
                    classTime,classPlace, point);
            courseMapper.addCourse(course);
            courseMapper.addTeachersCourse(new TeachersCourse(teacher,id));
            res.put("code","0");
            res.put("msg","添加课程成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加课程失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addSelectedCourse(Integer id, String selectCourseId) {
        Map<String, String> res = new HashMap<>();
        String[] courses = selectCourseId.split(",");
        try {
            for(int i = 0; i < courses.length; i++){
                SelectedCourse selectedCourse = new SelectedCourse(getIdByN(id),courses[i]);
                courseMapper.addSelectedCourse(selectedCourse);
            }
            res.put("code","0");
            res.put("msg","添加选课成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加选课失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addAbsence(Integer id, String skipCourseName, String skipCourseDate,
                                          String skipCourseTeacher) {
        Map<String, String> res = new HashMap<>();
        try {
            Absence absence = new Absence(getIdByN(id), skipCourseName, skipCourseDate, skipCourseTeacher);
            courseMapper.addAbsence(absence);
            res.put("code","0");
            res.put("msg","添加考勤信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加考勤信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addHomework(Integer id, String homeworkName, String homeworkDate,
                                           String teacher, String assessment) {
        Map<String, String> res = new HashMap<>();
        try {
            Homework homework = new Homework( getIdByN(id), homeworkName, homeworkDate, teacher, assessment );
            courseMapper.addHomework(homework);
            res.put("code","0");
            res.put("msg","添加作业成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加作业失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addGrades(String data) {
        Map<String, String> res = new HashMap<>();
        JSONArray jsonArray = JSONArray.fromObject(data);
        try {
            for(int i = 0;i< jsonArray.size();i++){
                Grades grades = new Grades();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Iterator iterator = jsonObject.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry entry = (Map.Entry)iterator.next();
                    String key = entry.getKey().toString();
                    String value = entry.getValue().toString();
                    if(key.equals("num")){
                        grades.setNum(value);
                    }else {
                        grades.setCourseId(key);
                        grades.setPoints(Double.parseDouble(value));
                    }
                }
                courseMapper.addGrades(grades);
            }
            res.put("code","0");
            res.put("msg","添加成绩成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加成绩失败");
            res.put("err", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addEvaluate(String num, String area, Double points) {
        Map<String, String> res = new HashMap<>();
        Evaluate evaluate = new Evaluate(num, area, points);
        try {
            courseMapper.addEvaluation(evaluate);
            res.put("code","0");
            res.put("msg","评价成功");
        }catch (Exception e){
            res.put("code","0");
            res.put("msg","评价失败");
            res.put("err",String.valueOf(e));
        }
        return res;
    }
}
