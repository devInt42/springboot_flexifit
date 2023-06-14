package com.example.moodmix.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moodmix.service.*;
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
    private FaqService faqService;
    private OrderService orderService;
    private ReviewService reviewService;
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
    @PostMapping("/getProductDetail")
    public APIResult getProductDetail(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getOneProduct(dataParam);
        return result;
    }
    @PostMapping("/getProductColor")
    public APIResult getProductColor(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getColorList(dataParam);
        return result;
    }
    @PostMapping("/getProductSize")
    public APIResult getProductSize(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getSizeList(dataParam);
        return result;
    }

    @PostMapping("/InsertWishList")
    public APIResult InsertWishList(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.insertWishList(dataParam);
        return result;
    }
    @PostMapping("/getWishList")
    public APIResult GetWishList(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getWishList(dataParam);
        return result;
    }
    @PostMapping("/insertMyBag")
    public APIResult insertMyBag(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.insertMyBag(dataParam);
        return result;
    }
    @PostMapping("/getShoppingList")
    public APIResult getShoppingList(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = productService.getShoppingList(dataParam);
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

    @PostMapping("/UpdateQnaInfo")
    public APIResult UpdateQnaInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = qnaService.updateInfo(dataParam);
        return result;
    }

    @PostMapping("/UpdateQnaReply")
    public APIResult UpdateQnaReply(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = qnaService.updateReply(dataParam);
        return result;
    }

    @PostMapping("/UpdateFaqInfo")
    public APIResult UpdateFaqInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = qnaService.updateInfo(dataParam);
        return result;
    }

    @PostMapping("/InsertFaqInfo")
    public APIResult InsertFaqInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = faqService.insertInfo(dataParam);
        return result;
    }

    @PostMapping("/InsertOrderInfo")
    public APIResult InsertOrderInfo(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = orderService.insertInfo(dataParam);
        return result;
    }

    @PostMapping("/getReviewByUser")
    public APIResult getReviewByUser(@RequestBody Map<String, Object> param, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        APIResult result = new APIResult();
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        result = reviewService.getReviewByUser(dataParam);
        return result;
    }
}
