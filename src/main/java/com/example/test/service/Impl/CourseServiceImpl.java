package com.example.test.service.Impl;

import com.example.test.bean.*;
import com.example.test.mapper.CourseMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.CourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
//    private Integer getIdByN(Integer num){
//        return studentMapper.getStuIdByNum(num);
//    }
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
    public Map<String, String> addSelectedCourse(Integer num, String selectCourseId) {
        Map<String, String> res = new HashMap<>();
        String[] courses = selectCourseId.split(",");
        try {
            for(int i = 0; i < courses.length; i++){
                SelectedCourse selectedCourse = new SelectedCourse(num,courses[i]);
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
    public Map<String, String> deleteSelectedCourse(Integer num, String selectCourseId) {
        Map<String, String> res = new HashMap<>();
        String[] courses = selectCourseId.split(",");
        try {
            int n = 0;
            for(int i = 0; i < courses.length; i++){
                SelectedCourse selectedCourse = new SelectedCourse(num,courses[i]);
                int k = courseMapper.deleteSelectedCourse(selectedCourse);
                n += k;
            }
            if(n == 0){
                res.put("code","2");
                res.put("msg","无此人选此课记录");
            }else {
                res.put("code","0");
                res.put("msg","退课成功");
            }

        }catch (Exception e){
            res.put("code","1");
            res.put("msg","退课失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addAbsence(Integer num, String skipCourseName, String skipCourseDate,
                                          String skipCourseTeacher) {
        Map<String, String> res = new HashMap<>();
        try {
            Absence absence = new Absence(num, skipCourseName, skipCourseDate, skipCourseTeacher);
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
    public Map<String, String> addHomework(Integer num, String homeworkName, String homeworkDate,
                                           String teacher, String assessment) {
        Map<String, String> res = new HashMap<>();
        try {
            Homework homework = new Homework( num, homeworkName, homeworkDate, teacher, assessment );
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
    public Map getGrades(Integer num) {
        Map res = new HashMap();
        List data = new ArrayList<>();
        List<Grades> gradesList = courseMapper.getGrades(num);
        try{
            for(Grades grades : gradesList){
                Map data_element = new HashMap();
                data_element.put("grades",grades);
                String course_id_s = grades.getCourseId();
                Course course = courseMapper.getCourse(Integer.parseInt(course_id_s));
                if(course == null){
                    res.put("code","2");
                    res.put("msg","此人学习的课程不存在");
                    break;
                }else{
                    data_element.put("course",course);
                    data.add(data_element);
                }

                res.put("code","0");
                res.put("msg","获取成绩成功");
                res.put("data",data);
            }
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","获取成绩失败");
            res.put("err",String.valueOf(e));
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

    @Override
    public Map getCourseTable(Integer num) {
        Map res = new HashMap();

        List<Course> courseList = courseMapper.getSelectedCourse(num);
        //初始化
        List<List<Map<String, String>>> data = new ArrayList<>();
        for(int i=0;i<7;i++){
            List<Map<String, String>> day_table = new ArrayList<>();
            for(int j=0;j<5;j++){
                day_table.add(new HashMap<>());
            }
            data.add(day_table);
        }

        try {
            Map<String, String> data_element = new HashMap<>();
            for(Course course : courseList){
                data_element.put("class_name",course.getCourseName());
                String jsonString = course.getClassTime();
                JSONObject jsonObject = JSONObject.fromObject(jsonString);
                String start_week = jsonObject.get("start_week") +"";
                String end_week = jsonObject.get("end_week") +"";
                data_element.put("start_week",start_week);
                data_element.put("end_week",end_week);
                List<Integer> day = (List<Integer>) jsonObject.get("date");
                List<Integer> time = (List<Integer>) jsonObject.get("time");
                for(int d : day){
                    if(d<1) continue;
                    List<Map<String, String>> day_table = data.get(d-1);
                    for(int t : time){
                        if(t<1) continue;
                        day_table.set(t-1,data_element);
                    }
                }
            }
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","获取课表失败");
        }

        res.put("data",data);
        res.put("code","0");

        return res;
    }
}
