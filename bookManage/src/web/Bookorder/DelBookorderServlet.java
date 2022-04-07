package web.Bookorderorder;

import dao.BookorderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelBookorderServlet", value = "/DelBookorderServlet")
public class DelBookorderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookorderDao bookorderDao = new BookorderDao();
        try {
            boolean flag = bookorderDao.delBookorderById(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
