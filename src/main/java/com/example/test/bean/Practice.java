package com.example.test.bean;

import lombok.Data;

@Data
public class Practice {
    private String studentNum;
    private String description;
    private String practiceTime;
    private Double hours;
    private String practiceType;
    private String eventId;

    public Practice(String studentNum, String description, String practiceTime, Double hours, String practiceType) {
        this.studentNum = studentNum;
        this.description = description;
        this.practiceTime = practiceTime;
        this.hours = hours;
        this.practiceType = practiceType;
    }

    public Practice(String studentNum, String description,
                    String practiceTime, Double hours, String practiceType, String eventId) {
        this.studentNum = studentNum;
        this.description = description;
        this.practiceTime = practiceTime;
        this.hours = hours;
        this.practiceType = practiceType;
        this.eventId = eventId;
    }
}
