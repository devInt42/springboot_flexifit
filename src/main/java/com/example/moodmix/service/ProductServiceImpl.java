package com.example.moodmix.service;

import com.example.moodmix.mapper.*;
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


    @Override
    public APIResult getAllProducts(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> productList = sqlSession.getMapper(ProductMapper.class).getAllProducts(dataParam);
        result.setResultData(productList);
        return result;
    }

    @Override
    public int getCountByCategory(String category) {
        return sqlSession.getMapper(ProductMapper.class).getCount(category);
    }

    @Override
    public int getTotalCount() {
        return sqlSession.getMapper(ProductMapper.class).getTotalCount();
    }

    @Override
    public APIResult getProductBySort(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> productList = sqlSession.getMapper(ProductMapper.class).getProductBySort(dataParam);
        result.setResultData(productList);
        return result;
    }

    @Override
    public APIResult getOneProduct(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> productList = sqlSession.getMapper(ProductMapper.class).getProductInfo(dataParam);
        result.setResultData(productList);
        return result;
    }

    @Override
    public APIResult getColorList(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> ColorList = sqlSession.getMapper(ProductMapper.class).getColorList(dataParam);
        result.setResultData(ColorList);
        return result;
    }

    @Override
    public APIResult getSizeList(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> SizeList = sqlSession.getMapper(ProductMapper.class).getSizeList(dataParam);
        result.setResultData(SizeList);
        return result;
    }

    @Override
    public APIResult insertWishList(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        sqlSession.getMapper(ProductMapper.class).insertWishList(dataParam);
        return result;

    }

    @Override
    public APIResult getWishList(Map<String, Object> dataParam) {
        APIResult result = new APIResult();
        List<Map<String, Object>> WishList = sqlSession.getMapper(ProductMapper.class).getWishList(dataParam);
        result.setResultData(WishList);
        return result;
    }

    @Override
    public int deleteWishList(Map<String, Object> dataParam) {
        return sqlSession.getMapper(ProductMapper.class).deleteWishList(dataParam);
    }


}

