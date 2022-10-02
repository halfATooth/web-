package com.example.test.bean;

import lombok.Data;

@Data
public class Evaluate {
    private String num;
    private String area;
    private Double points;

    public Evaluate(String num, String area, Double points) {
        this.num = num;
        this.area = area;
        this.points = points;
    }
}
