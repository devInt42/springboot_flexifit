package com.example.moodmix.controller;

import com.example.moodmix.service.LoginService;
import com.example.moodmix.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public int checkSignUp(@RequestBody Map<String,Object> param) {
        Map<String,Object> dataParam = (Map<String,Object>) param.get("data");

        // 값이 비어있는지 확인
        if (dataParam.containsValue(null) || dataParam.containsValue("")) {
            // 필드값 중 null 값 막음.
            return -1;
        }

        int result = SignUpService.checkSignUp(dataParam);
        System.out.println(result); // 중복체크
        return result;
    }

}
