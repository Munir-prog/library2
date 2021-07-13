package com.mprog.learn.servlets;

import com.mprog.dto.AuthorDto;
import com.mprog.service.AuthorService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private static final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var authorDto = authorService.findAll();
        req.setAttribute("authors", authorDto);
        req.getSession().setAttribute("authorsMap", authorDto.stream()
                .collect(Collectors.toMap(AuthorDto::getId, AuthorDto::getFullName)));


        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
