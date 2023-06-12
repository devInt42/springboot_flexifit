package com.example.moodmix.service;

import com.example.moodmix.model.APIResult;

import java.util.List;
import java.util.Map;

public interface ProductService {
    APIResult getAllProducts(Map<String,Object>dataParam);

    int getCountByCategory(String category);

    int getTotalCount();
    int  getCountByShop(int userSeq);
    APIResult getProductBySort(Map<String,Object>dataParam);
    APIResult getOneProduct(Map<String,Object>dataParam);
    APIResult getColorList(Map<String,Object>dataParam);
    APIResult getSizeList(Map<String,Object>dataParam);
    APIResult insertWishList(Map<String, Object> dataParam);
    APIResult getWishList(Map<String, Object> dataParam);
    int deleteWishList(Map<String, Object> dataParam);
    int deleteShoppingList(Map<String, Object> dataParam);
    APIResult insertMyBag(Map<String, Object> dataParam);
    APIResult getShoppingList(Map<String, Object> dataParam);

}
