package cn.itcast.chapter11.example;

import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example04 {
    public static DataSource ds = null;

    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource("itcast");
        ds = cpds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
