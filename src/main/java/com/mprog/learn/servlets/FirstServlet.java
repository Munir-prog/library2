package com.mprog.learn.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try (var outputStream = resp.getOutputStream();
             var inputStream = FirstServlet.class.getClassLoader().getResourceAsStream("application.properties")) {
            outputStream.write(inputStream.readAllBytes());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var reader = req.getReader();
             var lines = reader.lines()) {
            lines.forEach(System.out::println);
        }
    }

}
