package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.Map;

public interface UserService {
    APIResult getUserInfo(Map<String,Object> dataParam);
//    APIResult UpdateUserInfo(Map<String,Object> dataParam);
}
