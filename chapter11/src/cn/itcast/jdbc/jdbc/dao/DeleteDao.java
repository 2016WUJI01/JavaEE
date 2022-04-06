package cn.itcast.jdbc.jdbc.dao;

import cn.itcast.jdbc.jdbc.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class DeleteDao {
    public static void main(String[] args) throws SQLException {
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from user where name='hello2'";
        int num = runner.update(sql);
        if (num > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }
}
