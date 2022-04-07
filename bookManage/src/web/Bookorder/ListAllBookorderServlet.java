package web.Bookorderorder;

import dao.BookorderDao;
import javaBean.Bookorder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ListAllBookorderServlet", value = "/ListAllBookorderServlet")
public class ListAllBookorderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookorderDao bookorderDao = new BookorderDao();
        ArrayList<Bookorder> bookorderlist;
        try {
            bookorderlist = bookorderDao.findAllBookorder();
            request.getSession().setAttribute("bookorders", bookorderlist);
            request.getRequestDispatcher("/Bookorder/listAllBookorder.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
