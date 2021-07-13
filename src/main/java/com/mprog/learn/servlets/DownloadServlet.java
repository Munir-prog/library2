package com.mprog.learn.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"new.json\"");
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var outputStream = resp.getOutputStream();
             var resourceAsStream = DownloadServlet.class.getClassLoader().getResourceAsStream("some.json")) {
            outputStream.write(resourceAsStream.readAllBytes());

        }

    }
}