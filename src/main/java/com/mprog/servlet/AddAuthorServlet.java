package com.mprog.servlet;

import com.mprog.dto.CreateAuthorDto;
import com.mprog.entity.Author;
import com.mprog.exception.ValidationException;
import com.mprog.service.AuthorService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.ADD_AUTHOR;
import static com.mprog.util.UrlPath.PROFILE;

@WebServlet(ADD_AUTHOR)
public class AddAuthorServlet extends HttpServlet {

    private final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("addAuthor"))
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var authorDto = CreateAuthorDto.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .yearOfBirth(req.getParameter("yearOfBirth"))
                .build();

        try {
            authorService.save(authorDto);
            resp.sendRedirect(PROFILE);
        } catch (ValidationException e){
            req.setAttribute("errors", e.getErrorList());
            doGet(req, resp);
        }
    }
}
