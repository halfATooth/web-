package com.example.test.service.Impl;

import com.example.test.bean.DayOff;
import com.example.test.bean.Payment;
import com.example.test.mapper.DayOffMapper;
import com.example.test.mapper.PaymentMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    DayOffMapper dayOffMapper;
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    StudentMapper studentMapper;
    private Integer getIdByN(Integer num){
        return studentMapper.getStuIdByNum(num);
    }

    @Override
    public Map<String, String> addDayOff(Integer id, String fromTime, String toTime, String reason) {
        Map<String, String> res = new HashMap<>();

        try {
            DayOff dayOff = new DayOff( getIdByN(id), fromTime, toTime, reason);
            dayOffMapper.addDayOff(dayOff);
            res.put("code","0");
            res.put("msg","添加请假信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加请假信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> addPayment(Integer id, String payTime, Double amount) {
        Map<String, String> res = new HashMap<>();

        try {
            Payment payment = new Payment( getIdByN(id), payTime, amount);
            paymentMapper.addPayment(payment);
            res.put("code","0");
            res.put("msg","添加消费信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加消费信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }
}
