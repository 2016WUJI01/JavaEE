package cn.itcast.chapter11.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Example01 {
    public static DataSource ds = null;

    static {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setInitialSize(5);
        ds = bds;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = ds.getConnection();
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println(metaData.getURL() + ",UserName=" + metaData.getUserName() + "," + metaData.getDriverName());
    }
}
