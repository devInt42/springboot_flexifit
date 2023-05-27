package com.example.moodmix.service;

import com.example.moodmix.mapper.QnaMapper;
import com.example.moodmix.mapper.UserMapper;
import com.example.moodmix.model.APIResult;
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

    @Override
    public int getTotalCount() {
        return sqlSession.getMapper(QnaMapper.class).getTotalCount();
    }

    @Override
    public APIResult insertInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(QnaMapper.class).insertQnaInfo(dataParam);
        result.setResultData(null);
        return result;
    }

    @Override
    public int getconfirmPwd(Map<String, Object> dataParam) {
        return sqlSession.getMapper(QnaMapper.class).getcheckPwd(dataParam);
    }

    @Override
    public APIResult updateInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(QnaMapper.class).updateInfo(dataParam);
        return result;
    }

    @Override
    public int delete(Map<String, Object> dataParam) {
        return sqlSession.getMapper(QnaMapper.class).deleteQna(dataParam);
    }


}
