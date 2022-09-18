package com.example.test.bean;

import lombok.Data;

@Data
public class Course {
    private int id;
    private String courseName;
    private String bookName;
    private String resName;
    private String pptUrl;
    private String teacher;
    private String classTime;
    private String classPlace;
    private Double point;

    public Course(int id, String courseName, String bookName, String resName,
                  String pptUrl, String teacher, String classTime, String classPlace, Double point) {
        this.id = id;
        this.courseName = courseName;
        this.bookName = bookName;
        this.resName = resName;
        this.pptUrl = pptUrl;
        this.teacher = teacher;
        this.classTime = classTime;
        this.classPlace = classPlace;
        this.point = point;
    }
}
