package com.example.moodmix.controller;

import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QnaService qnaService;

    @GetMapping("/list")
    public List<Map<String, Object>> getAllList(
            @RequestParam(value = "page", required = true) int page,
            @RequestParam(value = "itemsPerPage", required = true) int itemsPerPage) {
        int startPage = (page - 1) * itemsPerPage + 1;
        int endPage = page * itemsPerPage;
        return qnaService.getAllList(startPage, endPage);
    }

    @GetMapping("/count")
    public int getCount() {
        int count;
        count = qnaService.getTotalCount();
        return (count / 10) + 1;
    }

    @PostMapping("/insert")
    public APIResult InsertQna(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = qnaService.insertInfo(dataParam);
        Object resultData = res.getResultData();

        List<Map<String, Object>> resData = (List<Map<String, Object>>) resultData;
        result.setResultData(resData);

        return result;
    }

    @PostMapping("/check")
    public int checkPwd(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        int result = qnaService.getconfirmPwd(dataParam);
        int resultData;

        if (result == 0) {
            resultData = 0;
        } else {
            resultData = 1;
        }
        return resultData;
    }

    @PostMapping("/update")
    public APIResult UpdateQnaInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        APIResult result = new APIResult();

        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        APIResult res = qnaService.updateInfo(dataParam);
        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
        result.setResultData(resData);

        return result;
    }

}
