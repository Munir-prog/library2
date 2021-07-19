package com.mprog.servlet;

import com.mprog.dto.CreateBookDto;
import com.mprog.exception.ValidationException;
import com.mprog.service.BookService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.DELETE_BOOK;
import static com.mprog.util.UrlPath.PROFILE;

@WebServlet(DELETE_BOOK)
public class DeleteBookServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("deleteBook"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var createBookDto = CreateBookDto.builder()
                .bookName(req.getParameter("bookName"))
                .build();

        try {
            bookService.deleteBook(createBookDto);
            resp.sendRedirect(PROFILE);
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrorList());
            doGet(req, resp);
        }
    }
}
