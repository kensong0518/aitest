package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import main.dto.LoginRequest;    // 確保這些類存在並正確導入
import main.dto.LoginResponse;
import main.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private AuthService authService;   // 確保 AuthService 類存在並正確配置

    // 註冊方法
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest loginRequest) {
        authService.registerUser(loginRequest.getUsername(), loginRequest.getPassword()); // 調用 AuthService 方法註冊用戶
        return ResponseEntity.ok("User registered successfully");
    }

    // 登入方法
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);  // 調用 AuthService 方法登入用戶
        return ResponseEntity.ok(loginResponse);
    }
}
