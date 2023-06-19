package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.Map;

public interface ReviewService {
    APIResult getReviewByUser(Map<String, Object> dataParam);
    APIResult getReviewById(Map<String, Object> dataParam);
    APIResult insertInfo(Map<String, Object> dataParam);
    APIResult checkExistingReview(Map<String, Object> dataParam);
    int getTotalCount();
}
