package main.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import main.dto.LoginRequest;
import main.dto.LoginResponse;
import main.model.User;
import main.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private final String jwtSecret = System.getenv("JWT_SECRET_KEY"); // 从环境变量获取密钥
    private final long jwtExpirationMs = 86400000; // 24小时过期时间

    // 使用BCryptPasswordEncoder作为类成员变量，避免每次方法调用时实例化
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void registerUser(String username, String password) {
        // 加密用户密码并保存到数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        // 查找用户
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        System.out.println(loginRequest.getPassword());
        System.out.println(user.getPassword());

        // 验证密码是否匹配
//        if (!encoder.matches(loginRequest.getPassword(), user.getPassword())) {
    	if (!(loginRequest.getPassword().equals(user.getPassword()))) {
            throw new RuntimeException("Invalid credentials");
        }

        // 生成JWT Token
//        String token = Jwts.builder()
//                .setSubject(user.getUsername()) // 设置主题为用户名
//                .setIssuedAt(new Date()) // 设置生成时间
//                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // 设置过期时间
//                .signWith(SignatureAlgorithm.HS512, jwtSecret) // 使用HS512算法和密钥签名
//                .compact();

    	String mockToken = "mockToken";
        return new LoginResponse(mockToken); // 返回JWT token
    }
}
