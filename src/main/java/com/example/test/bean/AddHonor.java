package com.example.test.bean;

import lombok.Data;

@Data
public class AddHonor {
    private int id;
    private String honor;

    public AddHonor(int id, String honor) {
        this.id = id;
        this.honor = honor;
    }
}
