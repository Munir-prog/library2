package com.mprog.servlet;

import com.mprog.exception.PSQLExceptionWrapper;
import com.mprog.service.PublishingService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.DELETE_PUBLISHING;
import static com.mprog.util.UrlPath.PUBLISHING;

@WebServlet(DELETE_PUBLISHING)
public class DeletePublishingServlet extends HttpServlet {

    private final PublishingService publishingService = PublishingService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("publishing"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            publishingService.deletePublishing(req.getParameter("publishingName"));
            resp.sendRedirect(PUBLISHING);
        } catch (PSQLExceptionWrapper e){
            var message = e.getMessage();
            req.setAttribute("errors", e.getMessage());
            doGet(req, resp);
        }
    }
}
