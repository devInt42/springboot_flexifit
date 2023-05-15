package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    List<Map<String, Object>> getInfo(Map<String, Object> dataParam);
}
