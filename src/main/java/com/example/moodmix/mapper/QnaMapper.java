package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface QnaMapper {
    List<Map<String, Object>> getAllList(int startPage,int endPage);
    int getTotalCount();
    int getcheckPwd(Map<String, Object> dataParam);
    void updateInfo(Map<String, Object> dataParam);
    int deleteQna(Map<String, Object> dataParam);
    void insertImageUrl(Map<String, Object> dataParam);
    void updateQna(Map<String, Object> dataParam);
}



