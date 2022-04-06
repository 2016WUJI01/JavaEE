package cn.itcast.jdbc.jdbc.dao;

import cn.itcast.jdbc.jdbc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UpdateDao {
    public static void main(String[] args) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update user set name='hello2',password=111111 where name='hello1'";
        int num = runner.update(sql);
        if (num > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }
}
