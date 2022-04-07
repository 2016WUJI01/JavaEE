package web.Book;

import dao.BookDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelBookServlet", value = "/DelBookServlet")
public class DelBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        try {
            boolean flag = bookDao.delBookById(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
