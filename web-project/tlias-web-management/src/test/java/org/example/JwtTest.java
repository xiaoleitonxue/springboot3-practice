package org.example;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JwtTest {

    // 测试生成 JWT token
    @Test
    public void testGenerateJwt() {
        // 1. 准备自定义数据（载荷 Claims）
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "admin");
        dataMap.put("password", 1);

        // 2. 生成密钥（HS256 算法至少需要 32 字节密钥）
        SecretKey key = Keys.hmacShaKeyFor("abcdefghijklmnopqrstuvwxyz123456".getBytes(StandardCharsets.UTF_8));

        // 3. 构建并签名 JWT
        String jwt = Jwts.builder()
                .claims(dataMap)                                           // 添加自定义数据
                .expiration(new java.util.Date(System.currentTimeMillis() + 1000 * 3600))  // 设置过期时间（1小时）
                .signWith(key)                                             // 使用密钥签名
                .compact();                                                // 生成最终的 token 字符串
        System.out.println(jwt);
    }

    // 测试解析 JWT token
    @Test
    public void testParseJwt() {
        // 1. 待解析的 token（需要使用相同密钥生成的）
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc3NTYzMjAwN30.z2ekaamLMqaWasmmHDsx7ptT3mB0RtqjUmftUadzhSw";

        // 2. 使用相同的密钥（必须与生成时一致）
        SecretKey key = Keys.hmacShaKeyFor("abcdefghijklmnopqrstuvwxyz123456".getBytes(StandardCharsets.UTF_8));

        // 3. 解析 token 并验证签名
        io.jsonwebtoken.Claims claims = Jwts.parser()
                .verifyWith(key)           // 设置验证密钥
                .build()                   // 构建解析器
                .parseSignedClaims(jwt)    // 解析并验证签名
                .getPayload();             // 获取载荷数据

        // 4. 输出解析结果
        System.out.println(claims);
    }
}
