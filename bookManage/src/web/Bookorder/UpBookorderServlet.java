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

@WebServlet(name = "UpBookorderServlet", value = "/UpBookorderServlet")
public class UpBookorderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BookorderDao bookorderDao = new BookorderDao();
        Bookorder bookorder1 = new Bookorder();
        String id = request.getParameter("id");
        String situation = request.getParameter("situation");
        bookorder1.setId(id);
        bookorder1.setSituation(situation);
        int flag = 0;
        try {
            flag = bookorderDao.upBookorder(bookorder1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag != 0) {
            response.sendRedirect(request.getContextPath());
        } else {
            response.getWriter().println("修改失败！！");

        }
    }
}
