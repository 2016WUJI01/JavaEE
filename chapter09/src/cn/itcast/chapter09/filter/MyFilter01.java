package cn.itcast.chapter09.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MyFilter01", urlPatterns = "/MyServlet")
public class MyFilter01 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hello MyFilter01");
        chain.doFilter(request, response);
    }
}
