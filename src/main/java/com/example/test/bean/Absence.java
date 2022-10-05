package com.example.test.bean;

import lombok.Data;
/**缺勤信息*/
@Data
public class Absence {
    private int id;
    private String skipCourseName;
    private String skipCourseDate;
    private String skipCourseTeacher;

    public Absence(int id, String skipCourseName, String skipCourseDate, String skipCourseTeacher) {
        this.id = id;
        this.skipCourseName = skipCourseName;
        this.skipCourseDate = skipCourseDate;
        this.skipCourseTeacher = skipCourseTeacher;
    }
}
