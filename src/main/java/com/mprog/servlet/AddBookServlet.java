package com.mprog.servlet;

import com.mprog.dto.BookDto;
import com.mprog.dto.CreateBookDto;
import com.mprog.exception.ValidationException;
import com.mprog.service.BookService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet(ADD_BOOK)
public class AddBookServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("addBook"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var createBookDto = CreateBookDto.builder()
                .bookName(req.getParameter("bookName"))
                .pageCount(req.getParameter("pageCount"))
                .chapterCount(req.getParameter("chapterCount"))
                .bookImage(req.getPart("bookImage"))
                .bookPart(req.getPart("bookPart"))
                .yearOfRelease(req.getParameter("yearOfRelease"))
                .authorFirstName(req.getParameter("authorFirstName"))
                .authorLastName(req.getParameter("authorLastName"))
                .publishingName(req.getParameter("publishingName"))
                .build();

        try {
            bookService.saveBook(createBookDto);
            resp.sendRedirect(PROFILE);
        } catch (ValidationException e){
            req.setAttribute("errors", e.getErrorList());
            doGet(req, resp);
        }
    }

}
