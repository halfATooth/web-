package com.example.test.controller;

import com.example.test.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/practice")
public class PracticeController {
    @Autowired
    PracticeService practiceService;

    @ResponseBody
    @PostMapping("/social")
    public Map<String,String> social(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "social");
    }

    @ResponseBody
    @PostMapping("/contest")
    public Map<String,String> contest(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "contest");
    }

    @ResponseBody
    @PostMapping("/tech")
    public Map<String,String> tech(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "tech");
    }

    @ResponseBody
    @PostMapping("/lecture")
    public Map<String,String> lecture(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "lecture");
    }

    @ResponseBody
    @PostMapping("/innovation")
    public Map<String,String> innovation(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "innovation");
    }

    @ResponseBody
    @PostMapping("/internship")
    public Map<String,String> internship(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "internship");
    }
}
