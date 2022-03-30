package cn.itcast.jdbc.example;

import java.sql.*;

public class Example03 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select * from users";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.print("第2条数据的name值为：");
            rs.absolute(2);
            System.out.println(rs.getString("name"));
            System.out.print("第1条数据的name值为：");
            rs.beforeFirst();
            rs.next();
            System.out.println(rs.getString("name"));
            System.out.print("第4条数据的name值为：");
            rs.afterLast();
            rs.previous();
            System.out.println(rs.getString("name"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
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
