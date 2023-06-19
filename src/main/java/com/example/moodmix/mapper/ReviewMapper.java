package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface ReviewMapper {
    List<Map<String, Object>> getReviewByUser(Map<String, Object> dataParam);
    List<Map<String, Object>> getReviewById(Map<String, Object> dataParam);
    void insertInfo(Map<String, Object> dataParam);
    List<Map<String, Object>> checkExistingReview(Map<String, Object> dataParam);
    int getTotalCount();
    List<Map<String, Object>> getAllList();
}
