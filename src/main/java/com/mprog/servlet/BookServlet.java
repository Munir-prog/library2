package com.mprog.servlet;

import com.mprog.service.BookService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var bookId = Long.valueOf(req.getParameter("bookId"));
        var fullName = req.getParameter("fullName");
        req.setAttribute("books", bookService.findAllByAuthorId(bookId));

        req.getRequestDispatcher(JspHelper.getPath("books"))
                .forward(req, resp);

        //        req.setAttribute("full-name", fullName);

        //        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

//
//        try (var writer = resp.getWriter()) {
//            writer.write("<h1>" + fullName +  " books<h1>");
//            writer.write("<ul>");
//            bookService.findAllByAuthorId(bookId).forEach(bookDto -> writer.write("""
//                    <li>
//                    %s
//                    %s
//                    Publishing id: %d
//                    </li>
//                    **********************
//                    """.formatted(bookDto.getBookName(), bookDto.getBookDescription(), bookDto.getPublishingId())));
//            writer.write("</ul>");
//        }
    }
}
