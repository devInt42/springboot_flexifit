package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.List;
import java.util.Map;

public interface QnaService {
    List<Map<String, Object>> getAllList(int startPage,int endPage);
    int getTotalCount();
    APIResult insertInfo(Map<String,Object> dataParam);

}
