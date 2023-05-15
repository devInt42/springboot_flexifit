package com.example.moodmix.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moodmix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Map;

@RestController
public class APIResult {
    @Autowired
    private ProductService productService;

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

    @PostMapping("/getProductInfo")
    public APIResult getProductInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getInfo(dataParam);
        return result;
    }
}