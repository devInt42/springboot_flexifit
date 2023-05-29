package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.List;
import java.util.Map;

public interface FaqService {
    List<Map<String, Object>> getAllList();
    APIResult updateInfo(Map<String, Object> dataParam);
    int delete(Map<String, Object> dataParam);
    APIResult insertInfo(Map<String, Object> dataParam);
}
