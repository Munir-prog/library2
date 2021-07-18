package com.mprog.servlet;

import com.mprog.dto.CreateUserDto;
import com.mprog.entity.Gender;
import com.mprog.entity.Role;
import com.mprog.exception.ValidationException;
import com.mprog.service.UserService;
import com.mprog.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import static com.mprog.util.UrlPath.LOGIN;
import static com.mprog.util.UrlPath.REGISTRATION;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet(REGISTRATION)
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("roles", List.of("USER", "ADMIN"));
        req.setAttribute("roles", Role.values());
//        req.setAttribute("gender", List.of("MALE", "FEMALE"));
        req.setAttribute("gender", Gender.values());

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var createUserDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .image(req.getPart("image"))
                .build();


        try {
            userService.create(createUserDto);
            resp.sendRedirect(LOGIN);
        } catch (ValidationException e){
            req.setAttribute("errors", e.getErrorList());
            doGet(req, resp);
        }

    }
}
