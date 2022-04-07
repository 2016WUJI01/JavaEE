package web.User;

import dao.UsersDao;
import javaBean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindUserByIdServlet", value = "/FindUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDAO = new UsersDao();
        User user = new User();
        try {
            user = usersDAO.findUserById(Integer.parseInt(request.getParameter("id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/User/upUserForm.jsp");
    }
}
