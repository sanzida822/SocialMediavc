package org.example.socialmediamvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        boolean isLoginOrRegister = uri.endsWith("/login") || uri.endsWith("/register") || uri.contains("/auth");

        Object user = request.getSession().getAttribute("user");

        if (user == null && !isLoginOrRegister) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
            return false;
        }

        return true;
    }
}
