package com.example.test.bean;

import lombok.Data;

@Data
public class Like {
    private String num;
    private Integer likes;

    public Like(String num, Integer likes) {
        this.num = num;
        this.likes = likes;
    }
}
