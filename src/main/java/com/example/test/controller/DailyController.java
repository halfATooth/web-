package com.example.test.controller;

import com.example.test.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/daily")
public class DailyController {
    @Autowired
    DailyService dailyService;

    @ResponseBody
    @PostMapping("/pe")
    public Map<String,String> pe(Integer id, String description, String dailyTime, String place){
        return dailyService.addDaily(id, description, dailyTime, place,"pe");
    }

    @ResponseBody
    @PostMapping("/vacation")
    public Map<String,String> vacation(Integer id, String description, String dailyTime, String place){
        return dailyService.addDaily(id, description, dailyTime, place,"vacation");
    }

    @ResponseBody
    @PostMapping("/performance")
    public Map<String,String> performance(Integer id, String description, String dailyTime, String place){
        return dailyService.addDaily(id, description, dailyTime, place,"performance");
    }

    @ResponseBody
    @PostMapping("/party")
    public Map<String,String> party(Integer id, String description, String time, String place){
        return dailyService.addDaily(id, description, time, place,"party");
    }
}
