package com.example.moodmix.controller;
import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/listByUser")
    public APIResult getReviewByUser(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = reviewService.getReviewByUser(dataParam);

        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;

    }

    @PostMapping("/reviewById")
    public APIResult getReviewById(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = reviewService.getReviewById(dataParam);

        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;

    }
    @PostMapping("/insert")
    public APIResult InsertReviewInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = reviewService.insertInfo(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;

    }

    @PostMapping("/checkExistingReview")
    public APIResult checkExistingReview(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = reviewService.checkExistingReview(dataParam);

        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;

    }

    @GetMapping("/count")
    public int getCount() {
        int count;
        count = reviewService.getTotalCount();
        return count;
    }

}
