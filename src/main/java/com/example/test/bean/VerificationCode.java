package com.example.test.bean;

import lombok.Data;

@Data
public class VerificationCode {
    private String username;
    private long check_time;
    private int code;

    public VerificationCode(String username, long check_time, int code) {
        this.username = username;
        this.check_time = check_time;
        this.code = code;
    }
}
