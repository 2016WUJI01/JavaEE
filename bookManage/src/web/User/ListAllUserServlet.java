package web.User;

import dao.UsersDao;
import javaBean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ListAllUserServlet", value = "/ListAllUserServlet")
public class ListAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        ArrayList<User> userlist;
        try {
            userlist = usersDao.findAllUser();
            request.getSession().setAttribute("users", userlist);
            request.getRequestDispatcher("/User/listAllUser.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
