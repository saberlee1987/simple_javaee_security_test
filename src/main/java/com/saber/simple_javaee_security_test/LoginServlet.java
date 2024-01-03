package com.saber.simple_javaee_security_test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/error/index.jsp");
        } else if (action.equals("login")) {
            login(request, response);
        } else if (action.equals("logout")) {
            request.logout();
            response.sendRedirect(request.getContextPath() + "/login/login.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/error/index.jsp");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.isBlank() && password != null && !password.isBlank()) {
            try {
                request.login(username, password);
                response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
            } catch (ServletException e) {
                System.err.println(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/login/login.jsp?loginFailed");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login/login.jsp");
        }
    }
}
