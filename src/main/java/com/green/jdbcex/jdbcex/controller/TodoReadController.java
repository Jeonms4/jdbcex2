package com.green.jdbcex.jdbcex.controller;

import com.green.jdbcex.jdbcex.dto.TodoDTO;
import com.green.jdbcex.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tno = req.getParameter("tno");

        TodoDTO todoDTO = null;
        try {
            todoDTO = todoService.get(Long.parseLong(tno));
        } catch (Exception e) {
//            throw new RuntimeException(e);
            log.info("글 조회시 에러");
        }
        req.setAttribute("dto", todoDTO);
        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
    }
}
