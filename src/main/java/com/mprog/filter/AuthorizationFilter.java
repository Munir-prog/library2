package com.mprog.filter;

import com.mprog.dto.UserDto;
import com.mprog.util.UrlPath;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static com.mprog.util.UrlPath.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {


    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION, MAIN);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var requestURI = ((HttpServletRequest) request).getRequestURI();
        if (isPublicPath(requestURI) || isUserLoggedIn(request)){
            chain.doFilter(request, response);
        }else {
            var prevPage = ((HttpServletRequest) request).getHeader("referer");
            System.out.println(prevPage);
            ((HttpServletResponse) response).sendRedirect(prevPage != null ? prevPage : LOGIN); // must be start page
        }
    }

    private boolean isUserLoggedIn(ServletRequest request) {
        var user = (UserDto) ((HttpServletRequest) request).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String requestURI) {
        return PUBLIC_PATH.stream()
                .anyMatch(requestURI::startsWith);
    }
}
