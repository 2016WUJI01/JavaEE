package web.Book;

import dao.BookDao;
import javaBean.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsBookServlet", value = "/InsBookServlet")
public class InsBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        Book book = new Book();
        String bookname = request.getParameter("bookname");
        String reserve = request.getParameter("reserve");
        book.setBookname(bookname);
        book.setReserve(Integer.parseInt(reserve));
        boolean flag = false;
        try {
            flag = bookDao.insBook(book);
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
