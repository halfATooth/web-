package com.example.test.bean;

import lombok.Data;

@Data
public class Tag {
    private int id;
    private Double gpa;
    private Double rate;
    private Double cost;

    public Tag(int id, Double gpa, Double rate, Double cost) {
        this.id = id;
        this.gpa = gpa;
        this.rate = rate;
        this.cost = cost;
    }
}
