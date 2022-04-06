package cn.itcast.jdbc.jdbc.dao;

import cn.itcast.jdbc.jdbc.javabean.User;
import cn.itcast.jdbc.jdbc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class QueryDao {
    public static void main(String[] args) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from user";
        List<User> list = (List) runner.query(sql, new BeanListHandler(User.class));
        for (User user : list) {
            System.out.println(user.getId() + "," + user.getName() + "," + user.getPassword());
        }

    }
}
