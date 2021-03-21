package com.bishe.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//
@Component
@WebFilter(filterName = "CharsetFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("过滤器被执行");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        String token = httpServletRequest.getHeader("token");
        String ServletPath = httpServletRequest.getServletPath();
        System.out.println("ServletPath为"+ServletPath);
        if (ServletPath.equals("/token") ) {
            if (token == null || token == "") {
                System.out.println("无token用户，返回登陆界面");
                httpServletResponse.sendRedirect("/");
            }else {
                System.out.println("有token用户");
                redisTemplate.expire(token,30L, TimeUnit.MINUTES);
                filterChain.doFilter(servletRequest, servletResponse);
            }
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
//        System.out.println("过滤器销毁");
    }
}
