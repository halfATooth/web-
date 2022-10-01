package com.example.test.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UpDownloadImgService {
    Map<String, String> upload(MultipartFile img, String username);
    void download(HttpServletResponse response, String username);
}
