package com.example.moodmix.service;

import com.example.moodmix.mapper.FaqMapper;
import com.example.moodmix.mapper.QnaMapper;
import com.example.moodmix.mapper.UserMapper;
import com.example.moodmix.model.APIResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FaqServiceImpl implements FaqService{
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public List<Map<String, Object>> getAllList() {
        FaqMapper mapper = sqlSession.getMapper(FaqMapper.class);
        return mapper.getAllList();
    }

    @Override
    public APIResult updateInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(FaqMapper.class).updateInfo(dataParam);
        return result;
    }

    @Override
    public int delete(Map<String, Object> dataParam) {
        return sqlSession.getMapper(FaqMapper.class).deleteFaq(dataParam);
    }

    @Override
    public APIResult insertInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(FaqMapper.class).insertInfo(dataParam);
        return result;
    }
}
