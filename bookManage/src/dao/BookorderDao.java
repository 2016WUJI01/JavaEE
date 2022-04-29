package dao;

import javaBean.Bookorder;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookorderDao {
    public ArrayList<Bookorder> findAllBookorder() throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from bookorder";
        ArrayList<Bookorder> bookorders = (ArrayList<Bookorder>) runner.query(sql, new BeanListHandler(Bookorder.class));
        return bookorders;
    }

    public boolean delBookorderById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "DELETE FROM bookorder WHERE id=" + id;
        if (runner.update(sql) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insBookorder(Bookorder bookorder) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into bookorder(userid,bookid,number,date,situation) values(?,?,?,?,?)";
        int i = runner.update(sql, new Object[]{bookorder.getUserid(), bookorder.getBookid(), 1, LocalDate.now(), "待审批"});
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Bookorder findBookorderById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from bookorder WHERE id=?";
        Bookorder bookorder = runner.query(sql, new BeanHandler<>(Bookorder.class), id);
        return bookorder;
    }

    public int upBookorder(Bookorder bookorder) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "UPDATE bookorder set situation=? WHERE id=?";
        return runner.update(sql, new Object[]{bookorder.getSituation(), bookorder.getId()});
    }

    public ArrayList<Bookorder> findAllBookorderByUsername(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from bookorder WHERE userid =(select id from users where username = '" + username + "')";
        ArrayList<Bookorder> bookorders = (ArrayList<Bookorder>) runner.query(sql, new BeanListHandler(Bookorder.class));
        return bookorders;
    }
}
