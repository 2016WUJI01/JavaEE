package web.User;

import dao.BookorderDao;
import javaBean.Bookorder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserOrderServlet", value = "/UserOrderServlet")
public class UserOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookorderDao bookorderDao = new BookorderDao();
        ArrayList<Bookorder> bookorderlist;
        String username = (String) request.getSession().getAttribute("username");
        try {
            bookorderlist = bookorderDao.findAllBookorderByUsername(username);
            request.getSession().setAttribute("userbookorders", bookorderlist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/User/userOrder.jsp").forward(request, response);
    }
}
