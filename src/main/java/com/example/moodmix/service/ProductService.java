package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.List;
import java.util.Map;

public interface ProductService {
    APIResult getAllProducts(Map<String,Object>dataParam);

    int getCountByCategory(String category);

    int getTotalCount();

    APIResult getProductBySort(Map<String,Object>dataParam);
}