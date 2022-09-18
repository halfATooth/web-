package com.example.test.controller;

import com.example.test.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
public class HonorController {
    @Autowired
    HonorService honorService;
    @ResponseBody
    @PostMapping("/honor")
    public Map<String,String> honor(Integer id,String honor){
        return honorService.addHonor(id,honor);
    }

    @ResponseBody
    @PostMapping("/setHonor")
    public Map<String,String> setHonor(String details){
        return honorService.setHonor(details);
    }
}
