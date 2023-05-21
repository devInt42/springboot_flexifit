package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    List<Map<String, Object>> getInfoByCategory(Map<String, Object> dataParam);
    List<Map<String, Object>> getAllProducts();
    int getCount(String category);
    int getTotalCount();
    List<Map<String, Object>> getProductBySort(Map<String, Object> dataParam);
}