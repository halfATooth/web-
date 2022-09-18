package com.example.test.bean;

import lombok.Data;

@Data
public class DayOff {
    private int id;
    private String fromTime;
    private String toTime;
    private String reason;

    public DayOff(int id, String fromTime, String toTime, String reason) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.reason = reason;
    }
}
