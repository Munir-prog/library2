package com.mprog.servlet;

import com.mprog.service.BookService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Optional;

import static com.mprog.util.UrlPath.BOOKS;

@WebServlet(BOOKS)
public class BookServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional.ofNullable(req.getParameter("bookId"))
                .ifPresentOrElse(
                        bookId -> findPartly(Long.valueOf(bookId), req, resp),
                        () -> findAll(req, resp)
                );
    }

    @SneakyThrows
    private void findAll(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("books", bookService.findAllNameOfBooks());
        forward(req, resp);
    }

    @SneakyThrows
    private void findPartly(Long bookId, HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("books", bookService.findAllNameOfBooksByAuthorId(bookId));
        forward(req, resp);
    }

    @SneakyThrows
    private void forward(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(JspHelper.getPath("books"))
                .forward(req, resp);
    }
}
