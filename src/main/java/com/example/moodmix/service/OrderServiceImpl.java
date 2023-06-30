package com.example.moodmix.service;

import com.example.moodmix.mapper.OrderMapper;
import com.example.moodmix.model.APIResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public APIResult insertInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(OrderMapper.class).insertInfo(dataParam);
        return result;
    }
}
