package com.example.moodmix.controller;

import com.example.moodmix.service.LoginService;
import com.example.moodmix.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private SignUpService SignUpService;

    @PostMapping("/check")
    public Map<String, Object> checkLogin(@RequestBody Map<String, Object> param) {
        Map<String, Object> dataParam = (Map<String, Object>) param.get("data");
        Map<String, Object> result = loginService.checkLogin(dataParam);

        if (result != null) {
            // 로그인 성공
            result.put("success", true);
        } else {
            // 로그인 실패
           result = new HashMap<>();
            result.put("success", false);
        }

        return result;
    }

    @PostMapping("/signup")
    public Map<String,Object> checkSignUp(@RequestBody Map<String,Object> param){
        Map<String,Object> dataParam = (Map<String,Object>) param.get("data");
        Map<String,Object> result = SignUpService.checkSignUp(dataParam);
        System.out.println(result);
        return result; //수정
    }
}
