package com.green.jdbcex.jdbcex.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {
    //로그인 화면
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get....");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

    }

    // 로그인 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post");
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        // 로그인 정보를 한꺼번에 정보라는 키값으로 세션에 저장해야함

        String str = mid + mpw;
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", str);
        resp.sendRedirect("/jdbcex/todo/list");
    }
}
