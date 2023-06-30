package com.example.moodmix.mapper;

import java.util.Map;

public interface LoginMapper {
    Map<String, Object> checkLogin(Map<String, Object> dataParam);
}
