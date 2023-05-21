package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    List<Map<String, Object>> getAllProducts(Map<String, Object> dataParam);
    int getCount(String category);
    int getTotalCount();
    List<Map<String, Object>> getProductBySort(Map<String, Object> dataParam);
}