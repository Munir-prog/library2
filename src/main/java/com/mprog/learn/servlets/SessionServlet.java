package com.mprog.learn.servlets;

import com.mprog.dto.CreateUserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var session = req.getSession();
//        var user = (CreateUserDto) session.getAttribute(USER);
//            if (user == null){
//            user = CreateUserDto.builder()
//                    .id(25L)
//                    .email("test@gmail.com")
//                    .build();
//            session.setAttribute(USER, user);
//        }
     }
}
