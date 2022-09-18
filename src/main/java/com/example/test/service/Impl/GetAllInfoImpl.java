package com.example.test.service.Impl;

import com.example.test.bean.*;
import com.example.test.mapper.*;
import com.example.test.service.GetAllInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetAllInfoImpl implements GetAllInfo {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    PracticeMapper practiceMapper;
    @Autowired
    HonorMapper honorMapper;
    @Autowired
    DailyMapper dailyMapper;
    @Autowired
    DayOffMapper dayOffMapper;
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    TagMapper tagMapper;

    @Override
    public Map getStudent(Integer id) {
        Map res = new HashMap<>();
        if(id != null){
            Student student = studentMapper.getStudent(studentMapper.getNumById(id));
            res.put("student",student);
        }else{
            List<Student> students = studentMapper.getStudentAll();
            res.put("students",students);
        }
        return res;
    }

    @Override
    public Map getStudents(String numName) {
        Map res = new HashMap<>();
        if(numName != null){
            List<Student> student = studentMapper.getStudents(numName);
            res.put("student",student);
        }else{
            List<Student> students = studentMapper.getStudentAll();
            res.put("students",students);
        }
        return res;
    }

    @Override
    public Map getCourse(Integer id) {
        Map res = new HashMap<>();
        List<Course> sc = courseMapper.getSelectedCourse(id);
        List<Absence> ab = courseMapper.getAbsence(id);
        List<Homework> hw = courseMapper.getHomework(id);
        List<Grades> gr = courseMapper.getGrades(id);
        List<Double> gpas = new ArrayList<>();
        for (Grades grades : gr) {
            Double gpa = grades.getGpa();
            gpas.add(gpa);
        }
        //res.put("course",c);
        res.put("selectedCourse",sc);
        res.put("absence",ab);
        res.put("homework",hw);
        res.put("grades",gr);
        res.put("gpas",gpas);
        return res;
    }

    @Override
    public List<Course> getSetCourse() {
        return courseMapper.getCourses();
    }

    @Override
    public List<Honor> getSetHonor() {
        return honorMapper.getSetHonor();
    }


    @Override
    public Map getPractices(Integer id, String type) {
        Map res = new HashMap<>();
        if(type == null){
            List<Practice> practices = practiceMapper.getAllKindsPractice(id);
            res.put("practice",practices);
        }else {
            try {
                List<Practice> practices = practiceMapper.getOneTypePractice(id,type);
                res.put("practice",practices);
            }catch (Exception e){
                res.put("error",String.valueOf(e));
                res.put("reason","可能是type错误");
            }
        }
        return res;
    }

    @Override
    public Map getHonor(Integer id) {
        Map res = new HashMap<>();
        List<Honor> honors = honorMapper.getHonor(id);
        res.put("honor",honors);
        return res;
    }

    @Override
    public Map getDaily(Integer id, String type) {
        Map res = new HashMap<>();
        if(type == null){
            List<Daily> dailies = dailyMapper.getAllKindsDaily(id);
            res.put("daily",dailies);
        }else {
            List<Daily> dailies = dailyMapper.getOneTypeDaily(id,type);
            res.put("daily",dailies);
        }
        return res;
    }

    @Override
    public Map getDayOff(Integer id) {
        Map res = new HashMap<>();
        List<DayOff> dayOffs = dayOffMapper.getDayOff(id);
        res.put("dayOff",dayOffs);
        return res;
    }

    @Override
    public Map getPayment(Integer id) {
        Map res = new HashMap<>();
        List<Payment> payments = paymentMapper.getPayment(id);
        res.put("payment",payments);
        return res;
    }

    @Override
    public Map getAll(Integer id) {
        Map res = new HashMap<>();
        Map<String,List<String>> tag = new HashMap<>();
        List<String> tags = new ArrayList<>();

        //标签
        //tagMapper.deleteTags();
        List<Grades> gr = courseMapper.getAllGrades();
        List<Integer> ids = new ArrayList<>();
        ids.add(gr.get(0).getId());
        for(int i=1;i< gr.size();i++){
            Grades grades = gr.get(i);
            boolean p = true;
            for (Integer integer : ids) {
                if (integer == grades.getId()) {
                    p = false;
                    break;
                }
            }
            if(p) ids.add(grades.getId());
        }
        for(int i=0;i<ids.size();i++){
            Integer uid = ids.get(i);
            Double max = -1.0;
            for (Grades grades : gr) {
                if (grades.getId() == uid && grades.getGpa() > max)
                    max = grades.getGpa();
            }
            List<DayOff> dayOffs = dayOffMapper.getDayOff(uid);
            Double rate = (180- dayOffs.size())*1.0/180;
            List<Payment> payments = paymentMapper.getPayment(uid);
            Double cost = 0.0;
            if(payments.size() != 0){
                for(Payment p : payments)
                    cost += p.getAmount();
            }

            Tag tag1 = new Tag(uid,max,rate,cost);
            tagMapper.updateTags(tag1);
        }
        List<Tag> tagList = tagMapper.getTags();
        int index = 0;
        for(int i=0;i<tagList.size();i++){
            Tag t = tagList.get(i);
            if(id == t.getId())
                index = i;
        }
        double rank = (index+1)*1.0/tagList.size();
        if(rank >= 0.3)
            tags.add("学霸");
        boolean p = true;
        for(Tag t : tagList){
            if (t.getRate() > tagList.get(index).getRate()) {
                p = false;
                break;
            }
        }
        if(p)
            tags.add("陛下勤政");
        if(tagList.get(index).getCost() <= -3000)
            tags.add("土豪");

//        List<Double> gpas = new ArrayList<>();
//        for (Grades grades : gr) {
//            Double gpa = grades.getGpa();
//            gpas.add(gpa);
//        }
//        Collections.sort(gpas);
//        List<Grades> gr_per = courseMapper.getGrades(id);
//        List<Double> gpas_per = new ArrayList<>();
//        for (Grades grades : gr_per) {
//            Double gpa = grades.getGpa();
//            gpas_per.add(gpa);
//        }
//        boolean isKing = false;
//        for(int i=0;i<gpas_per.size();i++){
//            for(int j=0;j<gpas.size();j++){
//                Double p = gpas_per.get(i);
//                Double a = gpas.get(j);
//                if(p<=a){
//                    if((gpas.size()-j)*1.0/gpas.size() <= 0.3)
//                        isKing = true;
//                    break;
//                }
//            }
//        }
//        if(isKing)tags.add("学霸");



        res.put("student",getStudent(id));
        res.put("course",getCourse(id));
        res.put("practice",getPractices(id,null));
        res.put("honor",getHonor(id));
        res.put("daily",getDaily(id,null));
        res.put("dayOff",getDayOff(id));
        res.put("payment",getPayment(id));
        res.put("tag",tags);
        return res;
    }
}
