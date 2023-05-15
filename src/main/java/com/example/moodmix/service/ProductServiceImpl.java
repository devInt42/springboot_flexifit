package com.example.moodmix.service;

import com.example.moodmix.mapper.ProductMapper;
import com.example.moodmix.model.APIResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Autowired
    ProductMapper productMapper;

    @Override
    public APIResult getInfo(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        ProductMapper mapper = sqlSession.getMapper(param);
        List<Map<String, Object>> productList = productMapper.getInfo(dataParam);
        result.setResultData(productList);
        return result;
    }
}