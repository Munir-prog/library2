package com.mprog.servlet;

import com.mprog.service.PublishingService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.PUBLISHING;

@WebServlet(PUBLISHING)
public class PublishingServlet extends HttpServlet {

    private final PublishingService publishingService = PublishingService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var publishingName = req.getParameter("publishingName");
        if (publishingName == null) {
            req.setAttribute("publishing", publishingService.findAllName());
            req.getRequestDispatcher(JspHelper.getPath("publishing"))
                    .forward(req, resp);
        }else {
            req.setAttribute("publishingHouse", publishingService.findPublishingByName(publishingName));
            req.getRequestDispatcher(JspHelper.getPath("publishingPage"))
                    .forward(req, resp);
        }
    }
}
