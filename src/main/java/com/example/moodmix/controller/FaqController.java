package com.example.moodmix.controller;


import com.example.moodmix.service.FaqService;
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
@RequestMapping("/faq")
public class FaqController {
    @Autowired
    private FaqService faqService;

    @GetMapping("/list")
    public List<Map<String, Object>> getAllList() {
        return faqService.getAllList();
    }
}
