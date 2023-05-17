package com.example.moodmix.controller;

import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/shirts")
    public APIResult getProductInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {

        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        APIResult res = productService.getInfo(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }
}