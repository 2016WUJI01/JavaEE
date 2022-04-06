package cn.itcast.jdbc.jdbc.dao;

import java.sql.SQLException;

import cn.itcast.jdbc.jdbc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;

public class InsertDao {
    public static void main(String[] args) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into user (name,password) values ('hello1',123456)";
        int num = runner.update(sql);
        if (num > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }
}
