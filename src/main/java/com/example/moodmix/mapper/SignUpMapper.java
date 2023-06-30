package com.example.moodmix.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface SignUpMapper {

    int SignUp(Map<String, Object> dataParam);
}