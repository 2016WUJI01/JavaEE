package dao;

import javaBean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Utils;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDao {
    public ArrayList<User> findAllUser() throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from users";
        ArrayList<User> users = (ArrayList<User>) runner.query(sql, new BeanListHandler(User.class));
        return users;
    }


    public boolean delUserById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "DELETE FROM users WHERE id=" + id;
        int i = runner.update(sql);
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into users (username,password) values(?,?)";
        int i = runner.update(sql, new Object[]{user.getUsername(), user.getPassword()});
        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public User findUserById(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM users WHERE id=?";
        User user = runner.query(sql, new BeanHandler<>(User.class), id);
        return user;
    }

    public boolean findUserByUsername(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM users WHERE username=?";
        User user = runner.query(sql, new BeanHandler<>(User.class), username);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public int upUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "UPDATE users set username=?,password=? WHERE id=?";
        int i = runner.update(sql, new Object[]{user.getUsername(), user.getPassword(), user.getId()});
        return i;
    }

    public boolean login(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM users WHERE username =? and password = ?";
        User findeduser = runner.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        if (findeduser != null) {
            return true;
        } else {
            return false;
        }
    }

    public String findUseridByUsername(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT id FROM users WHERE username=?";
        String userid = runner.query(sql, new BeanHandler<>(User.class), username).getId();
        return userid;
    }
}
