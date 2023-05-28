package com.example.moodmix.service;

import com.example.moodmix.mapper.FaqMapper;
import com.example.moodmix.mapper.QnaMapper;
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
}
