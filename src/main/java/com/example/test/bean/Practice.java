package com.example.test.bean;

import lombok.Data;

@Data
public class Practice {
    private String studentNum;
    private String description;
    private String practiceTime;
    private Double hours;
    private String practiceType;

    public Practice(String studentNum, String description, String practiceTime, Double hours, String practiceType) {
        this.studentNum = studentNum;
        this.description = description;
        this.practiceTime = practiceTime;
        this.hours = hours;
        this.practiceType = practiceType;
    }
}
