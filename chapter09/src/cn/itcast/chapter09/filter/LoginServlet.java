package cn.itcast.chapter09.filter;

import cn.itcast.chapter09.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("itcast".equals(username) && "123456".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
            String autoLogin = request.getParameter("autoLogin");
            if (autoLogin != null) {
                Cookie cookie = new Cookie("autoLogin", username + "-" + password);
                cookie.setMaxAge(Integer.parseInt(autoLogin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("errerMsg", "用户名活密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
