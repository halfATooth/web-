package com.example.test.service;

import java.util.Map;

public interface DailyService {
    Map<String,String> addDaily(Integer id, String description, String dailyTime, String place,String type);
}
