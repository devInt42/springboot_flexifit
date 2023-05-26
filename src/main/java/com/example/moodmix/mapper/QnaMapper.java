package com.example.moodmix.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QnaMapper {
    List<Map<String, Object>> getAllList(int startPage,int endPage);
    int getTotalCount();
    void insertQnaInfo(Map<String, Object> dataParam);
}


