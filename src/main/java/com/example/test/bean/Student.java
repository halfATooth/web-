package com.example.test.bean;

import lombok.Data;

@Data
public class Student {
    private String studentName;
    private String studentNum;
    private Integer sex;
    private Integer age;
    private String birthday;
    private String telephone;

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
