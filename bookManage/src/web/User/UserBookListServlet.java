package web.User;

import dao.BookDao;
import javaBean.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserBookListServlet", value = "/UserBookListServlet")
public class UserBookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        ArrayList<Book> booklist;
        try {
            booklist = bookDao.findAllBook();
            request.getSession().setAttribute("books", booklist);
            request.getRequestDispatcher("/User/userBookList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
