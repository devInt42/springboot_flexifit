package com.example.moodmix.mapper;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    List<Map<String, Object>> getAllProducts(Map<String, Object> dataParam);
    int getCount(String category);
    int getCountByShop(Integer userSeq);
    int getTotalCount();
    List<Map<String, Object>> getProductBySort(Map<String, Object> dataParam);
    List<Map<String, Object>> getProductInfo(Map<String, Object> dataParam);
    List<Map<String, Object>> getColorList(Map<String, Object> dataParam);
    List<Map<String, Object>> getSizeList(Map<String, Object> dataParam);
    void insertWishList(Map<String, Object> dataParam);
    List<Map<String, Object>> getWishList(Map<String, Object> dataParam);
    int deleteWishList(Map<String, Object> dataParam);
    int deleteShoppingList(Map<String, Object> dataParam);
    void insertMyBag(Map<String, Object> dataParam);
    List<Map<String, Object>> getShoppingList(Map<String, Object> dataParam);

}
