package web.User;

import dao.UsersDao;
import javaBean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpUserServlet", value = "/UpUserServlet")
public class UpUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDAO = new UsersDao();
        User user1 = new User();
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user1.setId(id);
        user1.setUsername(username);
        user1.setPassword(password);
        int i = 0;
        try {
            i = usersDAO.upUser(user1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i != 0) {
            response.sendRedirect(request.getContextPath());
        } else {
            response.getWriter().println("修改失败！！");
        }

    }
}
