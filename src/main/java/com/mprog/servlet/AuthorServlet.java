package com.mprog.servlet;

import com.mprog.service.AuthorService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.mprog.util.UrlPath.AUTHORS;

@WebServlet(AUTHORS)
public class AuthorServlet extends HttpServlet {
    private static final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", authorService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("authors"))
                .forward(req, resp);


    }
}
