package com.mprog.servlet;

import com.mprog.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.mprog.util.UrlPath.MAIN;

import java.io.IOException;

@WebServlet(UrlPath.LOGOUT  )
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        resp.sendRedirect(MAIN); // must create start page

    }
}
