package com.example.test.bean;

import lombok.Data;

@Data
public class Practice {
    private int id;
    private String description;
    private String practiceTime;
    private Double hours;
    private String practiceType;

    public Practice(int id, String description, String practiceTime, Double hours, String practiceType) {
        this.id = id;
        this.description = description;
        this.practiceTime = practiceTime;
        this.hours = hours;
        this.practiceType = practiceType;
    }
}
