package web.Admin;

import dao.UsersDao;
import javaBean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        User user = new User();

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            user.setUsername(username);
            user.setPassword(password);
            if (usersDao.login(user)) {
                System.out.println("true");
                response.sendRedirect(request.getContextPath() + "/ListAllBookorderServlet ");
            } else {
                System.out.println("false");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
