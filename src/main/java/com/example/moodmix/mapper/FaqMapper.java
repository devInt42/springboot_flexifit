package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface FaqMapper {
    List<Map<String, Object>> getAllList();
    void updateInfo(Map<String, Object> dataParam);
    int deleteFaq(Map<String, Object> dataParam);
    void insertInfo(Map<String, Object> dataParam);
}
