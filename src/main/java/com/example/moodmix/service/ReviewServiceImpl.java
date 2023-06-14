package com.example.moodmix.service;

import com.example.moodmix.mapper.OrderMapper;
import com.example.moodmix.mapper.ProductMapper;
import com.example.moodmix.mapper.ReviewMapper;
import com.example.moodmix.model.APIResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ReviewServiceImpl implements  ReviewService{
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public APIResult getReviewByUser(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> ReviewList = sqlSession.getMapper(ReviewMapper.class).getReviewByUser(dataParam);
        result.setResultData(ReviewList);
        return result;
    }
}
