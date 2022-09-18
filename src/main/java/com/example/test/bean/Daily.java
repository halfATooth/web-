package com.example.test.bean;

import lombok.Data;

@Data
public class Daily {
    private int id;
    private String description;
    private String dailyTime;
    private String place;
    private String dailyType;

    public Daily(int id, String description, String dailyTime, String place, String dailyType) {
        this.id = id;
        this.description = description;
        this.dailyTime = dailyTime;
        this.place = place;
        this.dailyType = dailyType;
    }
}
