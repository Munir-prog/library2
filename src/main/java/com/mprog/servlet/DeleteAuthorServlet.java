package com.mprog.servlet;

import com.mprog.dto.CreateAuthorDto;
import com.mprog.exception.PSQLExceptionWrapper;
import com.mprog.exception.SomeThingWentWrongWhenDeletingAuthorException;
import com.mprog.service.AuthorService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.util.PSQLException;

import java.io.IOException;

import static com.mprog.util.UrlPath.DELETE_AUTHOR;
import static com.mprog.util.UrlPath.PROFILE;

@WebServlet(DELETE_AUTHOR)
public class DeleteAuthorServlet extends HttpServlet {

    private final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("deleteAuthor"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var authorDto = CreateAuthorDto.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .build();

        try {
            authorService.delete(authorDto);
            resp.sendRedirect(PROFILE);
        }catch (SomeThingWentWrongWhenDeletingAuthorException | PSQLExceptionWrapper e){
            req.setAttribute("errorMessage", e.getMessage() + "<br>Please remove all this author's books first");
            doGet(req, resp);
        }
    }
}
