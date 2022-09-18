package com.example.test.service;

import java.util.Map;

public interface StudentService {
    Map<String,String> addStudent(String studentName, String studentNum,
       Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
       String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
       String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
       Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
       String mName,String mPhone,String mWorkplace);
    Map<String,String> updateStudent(Integer id,String studentName, String studentNum,
       Integer sex, Integer age, String birthday, String telephone,String pName,String pPosition,
       String pEnterDate,String pGraduateDate,String jName,String jPosition,String jEnterDate,
       String jGraduateDate,String sName,String sPosition,String sEnterDate,String sGraduateDate,
       Integer familyNum,String familyPosition,String fName,String fPhone,String fWorkplace,
       String mName,String mPhone,String mWorkplace);
    Map<String,String> getStuBaseInfo(Integer id);
    Map<String,String> deleteStu(Integer id);
    Integer getNById(Integer id);
}
