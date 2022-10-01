package com.example.test.bean;

import lombok.Data;

@Data
public class TeachersCourse {
    private String teacher;
    private int selectCourseId;

    public TeachersCourse(String teacher, int selectCourseId) {
        this.teacher = teacher;
        this.selectCourseId = selectCourseId;
    }
}
