package cn.itcast.jdbc.example;

import java.sql.*;

public class Example02 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO users(name,password,email,birthday)" + "VALUES(?,?,?,?)";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, "zl");
            preStmt.setString(2, "123456");
            preStmt.setString(3, "zl@sina.com");
            preStmt.setString(4, "1989-12-23");
            preStmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                preStmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }

}
