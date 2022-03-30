package cn.itcast.jdbc.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Example01 {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select * from users";
            rs = stmt.executeQuery(sql);
            System.out.println("id | name | password | email | birthday");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String psw = rs.getString("password");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                System.out.println(id + " | " + name + " | " + psw + " | " + email + " | " + birthday);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
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
