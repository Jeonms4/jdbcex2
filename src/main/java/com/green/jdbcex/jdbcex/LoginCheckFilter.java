package com.green.jdbcex.jdbcex;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
// 필터 적용 시 @WebFilter추가, 특정 경로를 지정해서 해당 경로의 요청에 대해서 doFilter()를 실행
@WebFilter(urlPatterns = {"/todo/*"}) // /todo/... 로 시작하는 모든 경로에 대해서 필터링을 시도
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Login Check filter...");
        filterChain.doFilter(servletRequest, servletResponse);

        // ServletRequest의 하위인 HttpServletRequest의 객체에서 세션을 얻어와야함

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    }
}
