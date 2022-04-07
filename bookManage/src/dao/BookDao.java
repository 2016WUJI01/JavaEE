package dao;

import javaBean.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Utils;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
    public ArrayList<Book> findAllBook() throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from book";
        ArrayList<Book> books = (ArrayList<Book>) runner.query(sql, new BeanListHandler(Book.class));
        return books;
    }

    public boolean delBookById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "DELETE FROM book WHERE id=" + id;
        if (runner.update(sql) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insBook(Book book) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into book(bookname,reserve) values(?,?)";
        int i = runner.update(sql, new Object[]{book.getBookname(), book.getReserve()});
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Book findBookById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from book WHERE id=?";
        Book book = runner.query(sql, new BeanHandler<>(Book.class), id);
        return book;
    }

    public int upBook(Book book) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "UPDATE book set bookname=?,reserve=? WHERE id=?";
        return runner.update(sql, new Object[]{book.getBookname(), book.getReserve(), book.getId()});
    }
}
