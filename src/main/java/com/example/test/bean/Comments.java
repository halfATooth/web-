package com.example.test.bean;

import lombok.Data;

@Data
public class Comments {
    private String upNum;
    private String touristNum;
    private String content;

    public Comments(String upNum, String touristNum, String content) {
        this.upNum = upNum;
        this.touristNum = touristNum;
        this.content = content;
    }
}
