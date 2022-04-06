package web;

import dao.UsersDao;
import javaBean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsUserServlet", value = "/InsUserServlet")
public class InsUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDAO = new UsersDao();
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        boolean b = false;
        try {
            b = usersDAO.insUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            response.sendRedirect(request.getContextPath());
        } else {
            response.getWriter().println("插入失败！！");
        }
    }
}
