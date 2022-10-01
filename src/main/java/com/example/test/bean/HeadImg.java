package com.example.test.bean;

import lombok.Data;

@Data
public class HeadImg {
    private String num;
    private String fileName;

    public HeadImg(String num, String fileName) {
        this.num = num;
        this.fileName = fileName;
    }
}
