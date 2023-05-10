package com.example.moodmix.service;

import com.example.moodmix.mapper.SignUpMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public Map<String, Object> checkSignUp(Map<String, Object> dataParam) {
        SignUpMapper mapper = sqlSession.getMapper(SignUpMapper.class);
        int affectedRows = mapper.SignUp(dataParam);
        Map<String, Object> result = new HashMap<>();
        if (affectedRows == 1) {
            result.put("status", "success");
            result.put("message", "회원가입에 성공했습니다.");
        } else {
            result.put("status", "failure");
            result.put("message", "이미 존재하는 아이디입니다.");
        }
        return result;
    }
}
