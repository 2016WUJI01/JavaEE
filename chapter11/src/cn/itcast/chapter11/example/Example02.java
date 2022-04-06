package cn.itcast.chapter11.example;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Example02 {
    public static DataSource ds = null;

    static {
        Properties prop = new Properties();
        try {
            InputStream in = new Example02().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = ds.getConnection();
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println(metaData.getURL() + ",UserName=" + metaData.getUserName() + "," + metaData.getDriverName());
    }
}
