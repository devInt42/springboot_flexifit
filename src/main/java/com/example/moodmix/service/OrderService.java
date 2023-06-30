package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.Map;

public interface OrderService {
    APIResult insertInfo(Map<String, Object> dataParam);
}
