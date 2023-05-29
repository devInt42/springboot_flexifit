package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.List;
import java.util.Map;

public interface QnaService {
    List<Map<String, Object>> getAllList(int startPage,int endPage);
    int getTotalCount();
    int getconfirmPwd(Map<String,Object> dataParam);
    APIResult updateInfo(Map<String, Object> dataParam);
    int delete(Map<String, Object> dataParam);
    void insertImageUrl(Map<String, Object> dataParam);
    void updateQna(Map<String, Object> dataParam);

}
