package web.User;

import dao.BookorderDao;
import dao.UsersDao;
import javaBean.Bookorder;
import javaBean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
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
                BookorderDao bookorderDao = new BookorderDao();
                ArrayList<Bookorder> bookorderlist;
                request.getSession().setAttribute("username", username);
                try {
                    bookorderlist = bookorderDao.findAllBookorderByUsername(username);
                    request.getSession().setAttribute("userbookorders", bookorderlist);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect(request.getContextPath() + "/UserOrderServlet");
            } else {
                request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
