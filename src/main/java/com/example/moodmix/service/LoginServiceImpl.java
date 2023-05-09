package com.example.moodmix.service;

import com.example.moodmix.mapper.LoginMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public Map<String, Object> checkLogin(Map<String, Object> dataParam) {
        LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
        return mapper.checkLogin(dataParam);
    }

}
