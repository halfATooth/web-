package com.example.test.controller;

import com.example.test.service.UpDownloadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/img")
public class UpDownloadImgController {
    @Autowired
    private UpDownloadImgService upDownloadImgService;

    @ResponseBody
    @PostMapping("/upload")
    Map<String, String> upload(MultipartFile img, String studentNum){
        return upDownloadImgService.upload(img, studentNum);
    }

    /**使用的是流传输*/
    @ResponseBody
    @PostMapping("/download")
    void download(HttpServletResponse response, String num){
        upDownloadImgService.download(response, num);
    }
}
