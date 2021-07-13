package com.mprog.servlet;

import com.mprog.dto.UserDto;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.mprog.util.UrlPath.PROFILE;

@WebServlet(PROFILE)
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var user = (UserDto) req.getSession().getAttribute("user");
        req.setAttribute("userName", user.getName());
        req.getRequestDispatcher(JspHelper.getPath("profile"))
                .forward(req, resp);
    }
}
