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
    @PostMapping("/getSocial")
    public Map getSocial(String num){
        return practiceService.getOneTypePractices(num, "social");
    }
    @ResponseBody
    @PostMapping("/updateSocial")
    public Map updateSocial(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"social");
    }

    @ResponseBody
    @PostMapping("/contest")
    public Map<String,String> contest(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "contest");
    }
    @ResponseBody
    @PostMapping("/getContest")
    public Map getContest(String num){
        return practiceService.getOneTypePractices(num, "contest");
    }
    @ResponseBody
    @PostMapping("/updateContest")
    public Map updateContest(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"contest");
    }

    @ResponseBody
    @PostMapping("/tech")
    public Map<String,String> tech(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "tech");
    }
    @ResponseBody
    @PostMapping("/getTech")
    public Map getTech(String num){
        return practiceService.getOneTypePractices(num, "tech");
    }
    @ResponseBody
    @PostMapping("/updateTech")
    public Map updateTech(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"tech");
    }


    @ResponseBody
    @PostMapping("/lecture")
    public Map<String,String> lecture(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "lecture");
    }
    @PostMapping("/getLecture")
    public Map getLecture(String num){
        return practiceService.getOneTypePractices(num, "lecture");
    }
    @ResponseBody
    @PostMapping("/updateLecture")
    public Map updateLecture(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"lecture");
    }

    @ResponseBody
    @PostMapping("/innovation")
    public Map<String,String> innovation(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "innovation");
    }
    @PostMapping("/getInnovation")
    public Map getInnovation(String num){
        return practiceService.getOneTypePractices(num, "innovation");
    }
    @ResponseBody
    @PostMapping("/updateInnovation")
    public Map updateInnovation(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"innovation");
    }

    @ResponseBody
    @PostMapping("/internship")
    public Map<String,String> internship(String studentNum, String description, String time,Double hours){
        return practiceService.addPractice( studentNum, description, time, hours, "internship");
    }
    @PostMapping("/getInternship")
    public Map getInternship(String num){
        return practiceService.getOneTypePractices(num, "internship");
    }
    @ResponseBody
    @PostMapping("/updateInternship")
    public Map updateInternship(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"internship");
    }

    @ResponseBody
    @PostMapping("/deletePractice")
    public Map<String,String> deletePractice(String eventId){
        return practiceService.deletePractice(eventId);
    }


    @ResponseBody
    @PostMapping("/getAllPractices")
    public Map getAllPractices(String num){
        return practiceService.getAllPractices(num);
    }

    @ResponseBody
    @PostMapping("/updatePractice")
    public Map updateP(String eventId,String studentNum, String description, String time,Double hours){
        return practiceService.updatePractice(eventId,studentNum,description,time,hours,"");
    }
}
