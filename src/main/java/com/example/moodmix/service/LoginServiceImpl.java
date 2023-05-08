package com.example.moodmix.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SqlSessionTemplate sqlSesssion;

    @Override
    public List<Object> checkLogin() {
        return null;
    }
}
