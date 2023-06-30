package com.example.moodmix.controller;

import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clothes")
public class ProductInfoController {
    @Autowired
    private ProductService productService;

    @GetMapping("/count")
    public int getCount(@RequestParam(value = "category", required = false) String category) {
        int count;

        if (category == null || category.isEmpty()) {
            count = productService.getTotalCount();
        } else {
            count = productService.getCountByCategory(category);
        }
        return count;
    }

    @PostMapping("/sort")
    public APIResult getProductBySort(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {

        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        if (dataParam == null || dataParam.isEmpty() || dataParam.get("category").equals("all")) {
            APIResult res = productService.getAllProducts(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);
        } else {
            APIResult res = productService.getProductBySort(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);
        }
        return result;
    }

    @PostMapping("/detail")
    public APIResult getProductDetail(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {

        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = productService.getOneProduct(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }

    @PostMapping("/color")
    public APIResult getProductColor(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {

        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = productService.getColorList(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }

    @PostMapping("/size")
    public APIResult getProductSize(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {

        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = productService.getSizeList(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }

    @PostMapping("/wishlist/insert")
    public APIResult InsertWishList(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        List<Map<String, Object>> wishList = (List<Map<String, Object>>) dataParam.get("wishList");
        String clothId = dataParam.get("clothId").toString();

        //중복 체크
        boolean isClothIdMatched = wishList.stream().anyMatch(item -> item.get("cloth_id").toString().equals(clothId));
        if (isClothIdMatched) {
            result.setResultMsg("duplicate");
            return result;
        } else if (dataParam.get("userSeq") == null || clothId.trim().isEmpty() || dataParam.get("userSeq").toString().trim().isEmpty()) {
            result.setResultMsg("false");
            return result;
        } else {
            APIResult res = productService.insertWishList(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);
            return result;
        }
}

    @PostMapping("/getWishList")
    //중복 막기
    public APIResult getWishList(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = productService.getWishList(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);
        return result;
    }

    @PostMapping("/deleteWishList")
    //중복 막기
    public int deleteWishList(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        return productService.deleteWishList(dataParam);
    }

    @PostMapping("/deleteShoppingList")
    //중복 막기
    public int deleteShoppingList(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        return productService.deleteShoppingList(dataParam);
    }

    @PostMapping("/myBag/insert")
    //중복 막기
    public APIResult insertMyBag(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        if (dataParam.get("userSeq") == null || dataParam.get("userSeq").toString().trim().isEmpty()) {
            result.setResultMsg("false");
            return result;
        } else if (dataParam.get("totalCount") == null || Integer.parseInt(dataParam.get("totalCount").toString()) == 0) {
            result.setResultMsg("noData");
            return result;
        } else {
            APIResult res = productService.insertMyBag(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);
            return result;
        }
    }
    @PostMapping("/getShoppingList")
    public APIResult getShoppingList(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {

        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = productService.getShoppingList(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }

    @GetMapping("/shopcount")
    public int getShopCount(@RequestParam(value = "userSeq", required = false) Integer userSeq) {
        if (userSeq == null) {
            return 0;
        }
        return productService.getCountByShop(userSeq);
    }
}