package com.example.test.service.Impl;

import com.example.test.bean.Course;
import com.example.test.bean.Daily;
import com.example.test.mapper.DailyMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DailyServiceImpl implements DailyService {
    @Autowired
    DailyMapper dailyMapper;
    @Autowired
    StudentMapper studentMapper;
    private Integer getIdByN(Integer num){
        return studentMapper.getStuIdByNum(num);
    }
    @Override
    public Map<String, String> addDaily(Integer id, String description, String dailyTime,
                                        String place,String type) {
        Map<String, String> res = new HashMap<>();

        try {
            Daily daily = new Daily( getIdByN(id), description, dailyTime, place,type);
            dailyMapper.addDaily(daily);
            res.put("code","0");
            res.put("msg","添加日常信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加日常信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }
}
