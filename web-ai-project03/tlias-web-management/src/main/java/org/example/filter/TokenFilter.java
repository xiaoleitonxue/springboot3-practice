package org.example.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.utils.CurrentHolder;
import org.example.utils.JwtUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1. 获取到请求路径
        String path = request.getRequestURI();

        //2. 判断是否是登录请求，如果路径中包含 /login，说明是登录操作，放行
        if (path.contains("login")) {
            log.info("登录请求, 放行");
            filterChain.doFilter(request, response);
            return;
        }

        //3. 获取请求头中的token
        String token = request.getHeader("token");

        //4. 判断token是否存在，如果不存在，说明用户没有登录，返回错误信息(响应401状态码)
        if (token == null || token.isEmpty()) {
            log.info("令牌为空, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401状态码
            return;
        }

        //5. 如果token存在，校验令牌，如果校验失败 -> 返回错误信息(响应401状态码)
        try {
            Claims claims = JwtUtils.parseToken(token);
            //Integer id = Integer.valueOf(claims.getId());
            Integer id = (Integer) claims.get("id");
            CurrentHolder.setCurrentId(id);
            log.info("令牌解析成功，当前用户id为：{}", id);
        } catch (Exception e) {
            log.error("令牌解析失败，响应401，原因：", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401状态码
            return;
        }

        //6. 校验通过，放行
        log.info("令牌校验通过，放行");
        filterChain.doFilter(request, response);

        //7. 释放资源
        CurrentHolder.remove();
    }

}
