package com.mprog.servlet;

import com.mprog.service.AuthorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {
    private static final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()) {
            writer.write("<h1>List of Authors</h1>");
            writer.write("<ul>");
            authorService.findAll().forEach(authorDto -> {
                writer.write("""
                    <li>
                        <a href="/books?bookId=%d" >%s</a>
                    </li>
                    """.formatted(authorDto.getId(), authorDto.getFullName()));
            });
            writer.write("</ul>");
        }
    }
}
