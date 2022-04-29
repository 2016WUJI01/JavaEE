package web.Book;

import dao.BookDao;
import javaBean.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SearchBookServlet", value = "/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        ArrayList<Book> booklist;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            String searchname = request.getParameter("searchname");
            System.out.println(searchname);
            booklist = bookDao.searchBookByName(searchname);
            request.getSession().setAttribute("searchbooks", booklist);
            response.sendRedirect(request.getContextPath() + "/User/searchBookResult.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
