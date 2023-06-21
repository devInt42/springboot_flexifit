package com.example.moodmix.service;

import com.example.moodmix.mapper.*;
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

    @Override
    public APIResult getReviewById(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> ReviewList = sqlSession.getMapper(ReviewMapper.class).getReviewById(dataParam);
        result.setResultData(ReviewList);
        return result;
    }

    @Override
    public APIResult insertInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(ReviewMapper.class).insertInfo(dataParam);
        return result;
    }

    @Override
    public APIResult checkExistingReview(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> checkExistingReview = sqlSession.getMapper(ReviewMapper.class).checkExistingReview(dataParam);
        result.setResultData(checkExistingReview);
        return result;
    }

    @Override
    public int getTotalCount() {
            return sqlSession.getMapper(ReviewMapper.class).getTotalCount();
    }

    @Override
    public List<Map<String, Object>> getAllList() {
        ReviewMapper mapper = sqlSession.getMapper(ReviewMapper.class);
        return mapper.getAllList();
    }

    @Override
    public List<Map<String, Object>> allReview() {
        ReviewMapper mapper = sqlSession.getMapper(ReviewMapper.class);
        return mapper.allReview();
    }

}
