package web.Book;

import dao.BookDao;
import javaBean.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpBookServlet", value = "/UpBookServlet")
public class UpBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        Book book1 = new Book();
        String id = request.getParameter("id");
        String bookname = request.getParameter("bookname");
        int reserve = Integer.parseInt(request.getParameter("reserve"));
        book1.setId(id);
        book1.setBookname(bookname);
        book1.setReserve(reserve);
        int flag = 0;
        try {
            flag = bookDao.upBook(book1);
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
