package web.User;

import dao.UsersDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelUserServlet", value = "/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsersDao usersDAO = new UsersDao();
        try {
            boolean b = usersDAO.delUserById(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
