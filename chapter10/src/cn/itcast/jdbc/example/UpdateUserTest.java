package cn.itcast.jdbc.example;

import cn.itcast.example.domain.User;
import cn.itcast.jdbc.example.dao.UsersDao;

import java.util.Date;

public class UpdateUserTest {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        User user = new User();
        user.setId(4);
        user.setUsername("zhaoxiaoliu");
        user.setPassword("456");
        user.setEmail("zhaoxiaoliu@sina.com");
        user.setBirthday(new Date());
        boolean b = usersDao.update(user);
        System.out.println(b);
    }
}
