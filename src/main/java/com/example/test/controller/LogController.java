package com.example.test.controller;

import com.example.test.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    LogService logService;

    @ResponseBody
    @PostMapping("/dayOff")
    public Map<String,String> dayOff(Integer id, String fromTime, String toTime, String reason){
        return logService.addDayOff( id, fromTime, toTime, reason);
    }

    @ResponseBody
    @PostMapping("/payment")
    public Map<String,String> payment(Integer id, String payTime, Double amount){
        return logService.addPayment( id, payTime, amount);
    }
}
