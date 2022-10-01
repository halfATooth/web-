package com.example.test.service.Impl;

import com.example.test.bean.Practice;
import com.example.test.mapper.PracticeMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        try {
            Practice practice = new Practice(studentNum, description, practiceTime, hours, practiceType);
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
}
