package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<Map<String, Object>> getUserInfo(Map<String, Object> dataParam);
    void updateInfo(Map<String, Object> dataParam); // updateInfo 메서드 추가
}
