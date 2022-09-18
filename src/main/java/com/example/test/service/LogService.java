package com.example.test.service;

import java.util.Map;

public interface LogService {
    Map<String,String> addDayOff(Integer id, String fromTime, String toTime, String reason);
    Map<String,String> addPayment(Integer id, String payTime, Double amount);
}
