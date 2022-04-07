package web.Bookorder;

import dao.BookorderDao;
import javaBean.Bookorder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindBookorderByIdServlet", value = "/FindBookorderByIdServlet")
public class FindBookorderByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookorderDao bookorderDao = new BookorderDao();
        Bookorder bookorder = new Bookorder();
        try {
            bookorder = bookorderDao.findBookorderById(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("bookorder", bookorder);
        response.sendRedirect(request.getContextPath() + "/Bookorder/upBookorderForm.jsp");
    }
}
