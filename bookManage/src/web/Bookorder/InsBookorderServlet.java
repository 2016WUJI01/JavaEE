package web.Bookorderorder;

import dao.BookorderDao;
import dao.UsersDao;
import javaBean.Bookorder;
import javaBean.User;

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
        UsersDao usersDao = new UsersDao();
        String username = (String) request.getSession().getAttribute("username");
        String userid = null;
        try {
            userid = usersDao.findUseridByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String bookid = request.getParameter("bookid");
        System.out.println(userid+bookid);
        bookorder.setUserid(userid);
        bookorder.setBookid(bookid);
        boolean flag = false;
        try {
            flag = bookorderDao.insBookorder(bookorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/UserOrderServlet");
        } else {
            response.getWriter().println("借书失败！！");
        }
    }
}
