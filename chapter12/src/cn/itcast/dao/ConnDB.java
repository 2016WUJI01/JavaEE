package cn.itcast.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnDB {
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;
    private static String propFileName = "connDB.properties";
    private static Properties prop = new Properties();
    private static String dbClassName = "";
    private static String dbUrl = "";
    private static String user = "";
    private static String pass = "";

    static {
        try {
            InputStream in = ConnDB.class.getResourceAsStream(propFileName);
            prop.load(in);
            dbClassName = prop.getProperty("DB_CLASS_NAME");
            dbUrl = prop.getProperty("DB_URL");
            user = prop.getProperty("user");
            pass = prop.getProperty("pass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConection() {
        try {
            Class.forName(dbClassName).newInstance();
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        if (conn == null) {
            System.err.print("连接失败");
        }
        return conn;
    }

    public ResultSet executeQuery(String sql) {
        try {
            conn = getConection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.print(ex.getErrorCode());
        }
        return rs;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
