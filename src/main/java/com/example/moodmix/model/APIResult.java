package com.example.moodmix.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moodmix.service.ProductService;
import com.example.moodmix.service.QnaService;
import com.example.moodmix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class APIResult {
    @Autowired
    private ProductService productService;
    private UserService userService;
    private QnaService qnaService;

    private int resultCode;
    private String resultMsg;
    private Object resultData;

    public APIResult() {
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return this.resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String toString() {
        return "Result [resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", resultData=" + this.resultData + "]";
    }

    @PostMapping("/getProductBySort")
    public APIResult getProductBySort(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getProductBySort(dataParam);
        return result;
    }

    @PostMapping("/getUserInfo")
    public APIResult getUserInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = userService.getUserInfo(dataParam);
        return result;
    }

    @PostMapping("/UpdateUserInfo")
    public APIResult UpdateUserInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = userService.updateInfo(dataParam);
        return result;
    }

    @PostMapping("/InsertQna")
    public APIResult InsertQna(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = qnaService.insertInfo(dataParam);
        return result;
    }

    @PostMapping("/UpdateQnaInfo")
    public APIResult UpdateQnaInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = qnaService.updateInfo(dataParam);
        return result;
    }

}
