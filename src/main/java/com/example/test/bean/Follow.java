package com.example.test.bean;

import lombok.Data;

@Data
public class Follow {
    private String num;
    private String followed;

    public Follow(String num, String followed) {
        this.num = num;
        this.followed = followed;
    }
}
