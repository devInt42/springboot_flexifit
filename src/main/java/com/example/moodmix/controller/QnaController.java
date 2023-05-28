package com.example.moodmix.controller;

import com.example.moodmix.model.APIResult;
import com.example.moodmix.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;



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

    @GetMapping("/countall")
    public int getCountall() {
        int count;
        count = qnaService.getTotalCount();
        return count +1 ;
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

//    @PostMapping("/update")
//    public APIResult UpdateQnaInfo(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
//        APIResult result = new APIResult();
//
//        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
//
//        APIResult res = qnaService.updateInfo(dataParam);
//        List<Map<String, Object>> resData = (List<Map<String, Object>>) res.getResultData();
//        result.setResultData(resData);
//
//        return result;    }

    @PostMapping("/delete")
    public int deleteQna(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");

        return qnaService.delete(dataParam);
    }

    @PostMapping("/insert")
    public void uploadFile(
            @RequestPart(value = "file", required = false) MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("userSeq") int userSeq,
            @RequestParam("userPassword") String userPassword
    ) {
        String uploadDir = "C:/uploads";
        String fileName = null;

        // 파일이 존재하는 경우에만 파일 처리
        if (file != null && !file.isEmpty()) {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                File dest = new File(uploadDir + File.separator + fileName);
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        // 제목, 내용, 비밀번호 중 하나라도 비어있으면 알림 메시지를 리턴
        if (title == null || title.isEmpty() || content == null || content.isEmpty() || userPassword == null || userPassword.isEmpty()) {
            return; //요기서 setResultMsg에 "false"담아서 반환
        }

        // DB에 이미지 URL 추가
        String imageUrl = fileName != null ? "http://localhost:8080/uploads/" + fileName : null;
        Map<String, Object> dataParam = new HashMap<>();
        dataParam.put("imageUrl", imageUrl);
        dataParam.put("title", title);
        dataParam.put("content", content);
        dataParam.put("userSeq", userSeq);
        dataParam.put("userPassword", userPassword);

        qnaService.insertImageUrl(dataParam); // DB에 이미지 URL 업데이트
    }
}
