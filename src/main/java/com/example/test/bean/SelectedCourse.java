package com.example.test.bean;

import lombok.Data;

@Data
public class SelectedCourse {
    private int id;
    private String selectCourseId;

    public SelectedCourse(int id, String selectCourseId) {
        this.id = id;
        this.selectCourseId = selectCourseId;
    }
}
