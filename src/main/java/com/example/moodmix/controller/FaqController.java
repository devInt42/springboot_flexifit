package com.example.moodmix.controller;


import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faq")
public class FaqController {
    @Autowired
    private FaqService faqService;

    @GetMapping("/list")
    public List<Map<String, Object>> getAllList() {
        return faqService.getAllList();
    }

    @PostMapping("/update")
    public APIResult UpdateFaqInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = faqService.updateInfo(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }
    @PostMapping("/delete")
    public int deleteFaq(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        return faqService.delete(dataParam);
    }
    @PostMapping("/insert")
    public APIResult InsertFaqInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        if (dataParam.get("title") == null || dataParam.get("content") == null || dataParam.get("title").toString().trim().isEmpty() || dataParam.get("content").toString().trim().isEmpty()) {
                result.setResultMsg("false");
                return result;
            }else {
            APIResult res = faqService.insertInfo(dataParam);
            List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
            result.setResultData(resData);

            return result;
        }
    }

}
