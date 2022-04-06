package cn.itcast.chapter11.example;

import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example03 {
    public static DataSource ds = null;

    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8");
            cpds.setUser("root");
            cpds.setPassword("root");
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(15);
            ds = cpds;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
