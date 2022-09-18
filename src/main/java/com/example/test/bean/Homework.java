package com.example.test.bean;

import lombok.Data;

@Data
public class Homework {
    private int id;
    private String homeworkName;
    private String homeworkDate;
    private String teacher;
    private String assessment;

    public Homework(int id, String homeworkName, String homeworkDate, String teacher, String assessment) {
        this.id = id;
        this.homeworkName = homeworkName;
        this.homeworkDate = homeworkDate;
        this.teacher = teacher;
        this.assessment = assessment;
    }
}
