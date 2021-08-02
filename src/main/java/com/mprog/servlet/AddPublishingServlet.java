package com.mprog.servlet;

import com.mprog.entity.Publishing;
import com.mprog.exception.ValidationException;
import com.mprog.service.PublishingService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.*;

@WebServlet(ADD_PUBLISHING)
public class AddPublishingServlet extends HttpServlet {

    private final PublishingService publishingService = PublishingService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("addPublishing"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var country = Publishing.builder()
                .publishingName(req.getParameter("publishingName"))
                .phoneNumber(req.getParameter("phoneNumber"))
                .website(req.getParameter("website"))
                .city(req.getParameter("city"))
                .country(req.getParameter("country"))
                .build();

        // try and catching
        try {
            publishingService.save(country);
            resp.sendRedirect(PROFILE);
        } catch (ValidationException e){
            req.setAttribute("errors", e.getErrorList());
            doGet(req, resp);
        }

    }
}
