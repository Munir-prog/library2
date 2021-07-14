package com.mprog.servlet;

import com.mprog.service.BookService;
import com.mprog.util.JspHelper;
import com.mprog.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.BOOK_PAGE;

@WebServlet(BOOK_PAGE)
public class BookPageServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var bookName = req.getParameter("bookName");
        req.setAttribute("book", bookService.findBookByName(bookName));
        req.getRequestDispatcher(JspHelper.getPath("bookPage"))
                .forward(req, resp);
    }
}
