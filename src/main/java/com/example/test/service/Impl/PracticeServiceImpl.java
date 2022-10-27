package com.example.test.service.Impl;

import com.example.test.bean.Practice;
import com.example.test.mapper.PracticeMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PracticeServiceImpl implements PracticeService {
    @Autowired
    PracticeMapper practiceMapper;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Map<String, String> addPractice(String studentNum, String description, String practiceTime,
                                           Double hours, String practiceType) {
        Map<String, String> res = new HashMap<>();
        String eventId = studentNum + "_" + System.currentTimeMillis();
        try {
            Practice practice = new Practice(studentNum, description, practiceTime, hours, practiceType,eventId);
            practiceMapper.addPractice(practice);
            res.put("code","0");
            res.put("msg","添加实践信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加实践信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> updatePractice(String eventId, String studentNum, String description,
                                              String practiceTime, Double hours, String practiceType) {
        Map<String, String> res = new HashMap<>();
        Practice practice = practiceMapper.getPractice(eventId);
        if(practice == null){
            res.put("code","2");
            res.put("msg","无此项活动，请检查eventId是否正确");
            return res;
        }
        if(!"".equals(studentNum)) practice.setStudentNum(studentNum);
        if(!"".equals(description)) practice.setDescription(description);
        if(!"".equals(practiceTime)) practice.setPracticeTime(practiceTime);
        if(hours != null) practice.setHours(hours);
        if(!"".equals(practiceType)) practice.setPracticeType(practiceType);
        try{
            practiceMapper.updatePractice(practice);
            res.put("code","0");
            res.put("msg","更新实践信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","更新实践信息失败");
        }
        return res;
    }


    @Override
    public Map<String, String> deletePractice(String eventId) {
        Map<String, String> res = new HashMap<>();
        try {
            practiceMapper.deletePractice(eventId);
            res.put("code","0");
            res.put("msg","删除实践信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","删除实践信息失败");
        }
        return res;
    }

    @Override
    public Map getAllPractices(String num) {
        Map res = new HashMap<>();
        try{
            List<Practice> practiceList = practiceMapper.getAllKindsPractice(num);
            res.put("code","0");
            res.put("msg","获取实践信息成功");
            res.put("data",practiceList);
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","获取实践信息失败");
        }
        return res;
    }

    @Override
    public Map getOneTypePractices(String num, String type) {
        Map res = new HashMap<>();
        try{
            List<Practice> practiceList = practiceMapper.getOneTypePractice(num, type);
            res.put("code","0");
            res.put("msg","获取实践信息成功");
            res.put("data",practiceList);
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","获取实践信息失败");
        }
        return res;
    }
}
