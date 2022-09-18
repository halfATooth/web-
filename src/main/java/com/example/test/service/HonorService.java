package com.example.test.service;

import java.util.Map;

public interface HonorService {
    Map<String,String> addHonor(Integer id, String honor);
    Map<String,String> setHonor(String details);
}
