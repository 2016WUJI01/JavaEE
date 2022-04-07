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

@WebServlet(name = "InsBookorderServlet", value = "/InsBookorderServlet")
public class InsBookorderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookorderDao bookorderDao = new BookorderDao();
        Bookorder bookorder = new Bookorder();
        String bookordername = request.getParameter("bookordername");
        String reserve = request.getParameter("reserve");
        bookorder.setBookid(bookordername);
        bookorder.setAdminid(bookordername);
        boolean flag = false;
        try {
            flag = bookorderDao.insBookorder(bookorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag) {
            response.sendRedirect(request.getContextPath());
        } else {
            response.getWriter().println("插入失败！！");
        }
    }
}
