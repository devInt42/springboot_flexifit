package com.example.moodmix.service;

import com.example.moodmix.mapper.QnaMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QnaServiceImpl implements QnaService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<Map<String, Object>> getAllList(int startPage, int endPage) {
        QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
        return mapper.getAllList(startPage, endPage);
    }
}
