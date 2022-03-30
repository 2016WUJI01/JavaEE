package cn.itcast.jdbc.example;

import cn.itcast.example.domain.User;
import cn.itcast.jdbc.example.dao.UsersDao;

import java.util.Date;

public class JdbcInsertTest {
    public static void main(String[] args) {
        UsersDao ud = new UsersDao();
        User user = new User();
        user.setId(5);
        user.setUsername("hl");
        user.setPassword("123");
        user.setEmail("hl@sina.com");
        user.setBirthday(new Date());
        boolean b = ud.insert(user);
        System.out.println(b);
    }
}
