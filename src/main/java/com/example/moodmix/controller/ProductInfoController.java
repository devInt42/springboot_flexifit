package com.example.moodmix.controller;

import com.example.moodmix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clothes")
public class ProductInfoController {
    @Autowired
    private ProductService productService;

    @PostMapping("/shirts")
    public Map<String, Object> getProductInfo(@RequestBody Map<String, Object> param) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        Map<String, Object> result = (Map<String, Object>) productService.getInfo(dataParam);
        return result;
    }
}
