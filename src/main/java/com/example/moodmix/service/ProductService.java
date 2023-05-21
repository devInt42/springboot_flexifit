package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.List;
import java.util.Map;

public interface ProductService {
    APIResult getInfo(Map<String,Object>dataParam);
    APIResult getAllProducts();

    int getCountByCategory(String category);

    int getTotalCount();

    APIResult getProductBySort(Map<String,Object>dataParam);
}