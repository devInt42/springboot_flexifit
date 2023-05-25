package com.example.moodmix.controller;

import com.example.moodmix.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return (count/10) +1;
    }
}
