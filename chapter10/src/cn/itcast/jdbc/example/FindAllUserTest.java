package cn.itcast.jdbc.example;

import cn.itcast.example.domain.User;
import cn.itcast.jdbc.example.dao.UsersDao;

import java.util.ArrayList;

public class FindAllUserTest {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        ArrayList<User> list = usersDao.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "条数据的username值为：" + list.get(i).getUsername());
        }
    }
}
