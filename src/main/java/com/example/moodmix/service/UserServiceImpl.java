package com.example.moodmix.service;

import com.example.moodmix.mapper.ProductMapper;
import com.example.moodmix.mapper.UserMapper;
import com.example.moodmix.model.APIResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public APIResult getUserInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> UserInfo = sqlSession.getMapper(UserMapper.class).getUserInfo(dataParam);
        result.setResultData(UserInfo);
        return result;
    }

//    @Override
//    public APIResult UpdateUserInfo(Map<String, Object> dataParam) {
//        APIResult result = new APIResult();
//        List<Map<String, Object>> UpdateInfo = sqlSession.getMapper(UserMapper.class).updateInfo(dataParam);
//        result.setResultData(UpdateInfo);
//        return result;
//    }
}
