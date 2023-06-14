package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface ReviewMapper {
    List<Map<String, Object>> getReviewByUser(Map<String, Object> dataParam);
}
