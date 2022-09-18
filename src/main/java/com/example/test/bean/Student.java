package com.example.test.bean;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String studentName;
    private String studentNum;
    private Integer sex;
    private Integer age;
    private String birthday;
    private String telephone;

    private String pName;
    private String pPosition;
    private String pEnterDate;
    private String pGraduateDate;
    private String jName;
    private String jPosition;
    private String jEnterDate;
    private String jGraduateDate;
    private String sName;
    private String sPosition;
    private String sEnterDate;
    private String sGraduateDate;

    private Integer familyNum;
    private String familyPosition;
    private String fName;
    private String fPhone;
    private String fWorkplace;
    private String mName;
    private String mPhone;
    private String mWorkplace;

    public Student( String studentName, String studentNum, Integer sex, Integer age,
           String birthday, String telephone, String pName, String pPosition, String pEnterDate,
           String pGraduateDate, String jName, String jPosition, String jEnterDate, String jGraduateDate,
           String sName, String sPosition, String sEnterDate, String sGraduateDate, Integer familyNum,
           String familyPosition, String fName, String fPhone, String fWorkplace, String mName, String mPhone,
           String mWorkplace) {
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.telephone = telephone;
        this.pName = pName;
        this.pPosition = pPosition;
        this.pEnterDate = pEnterDate;
        this.pGraduateDate = pGraduateDate;
        this.jName = jName;
        this.jPosition = jPosition;
        this.jEnterDate = jEnterDate;
        this.jGraduateDate = jGraduateDate;
        this.sName = sName;
        this.sPosition = sPosition;
        this.sEnterDate = sEnterDate;
        this.sGraduateDate = sGraduateDate;
        this.familyNum = familyNum;
        this.familyPosition = familyPosition;
        this.fName = fName;
        this.fPhone = fPhone;
        this.fWorkplace = fWorkplace;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mWorkplace = mWorkplace;
    }
    /**
     * 空构造器的目的是使SQL执行SELECT * 时，参数匹配
     *
     * 因为要实现主键自增，所以增加时构造器不设id
     * 因为自定义了构造器，导致select出来的参数和自定义的参数不匹配
     * 解决方法：
     *      1、增加无参构造器
     *      2、修改mapper.xml，即具体指明col不用*，由于参数过多，放弃
     * */
    public Student(){}

}
