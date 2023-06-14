package com.example.moodmix.controller;


import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/insert")
    public APIResult InsertOrderInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

            APIResult res = orderService.insertInfo(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);

            return result;

    }
}
