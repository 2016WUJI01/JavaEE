package cn.itcast.chapter09.filter;

import cn.itcast.chapter09.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("autologin".equals(cookies[i].getName())) {
                autologin = cookies[i].getValue();
                break;
            }
        }
        if (autologin != null) {
            String[] parts = autologin.split("-");
            String username = parts[0];
            String password = parts[1];
            if ("itcast".equals(username) && ("123456").equals(password)) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                request.getSession().setAttribute("user", user);
            }
        }
        chain.doFilter(request, response);
    }
}
