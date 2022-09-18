package com.example.test.bean;

import lombok.Data;

@Data
public class Payment {
    private int id;
    private String payTime;
    private Double amount;

    public Payment(int id, String payTime, Double amount) {
        this.id = id;
        this.payTime = payTime;
        this.amount = amount;
    }
}
