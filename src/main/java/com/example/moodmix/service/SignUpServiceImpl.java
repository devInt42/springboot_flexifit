package com.example.moodmix.service;

import com.example.moodmix.mapper.SignUpMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public int checkSignUp(Map<String, Object> dataParam) {
        SignUpMapper mapper = sqlSession.getMapper(SignUpMapper.class);
//        return mapper.SignUp(dataParam);
        return mapper.SignUp(dataParam);
    }
}
