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
    public int getCount(@RequestParam(value= "category", required = false) String category) {
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
        }else {
            APIResult res = productService.getProductBySort(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);
        }
        return result;
    }
}
