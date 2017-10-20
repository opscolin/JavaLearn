package com.colinspace;

import com.colinspace.entity.Users;
import com.colinspace.dao.UserDao;

import java.util.ArrayList;


/**
 * Created by colin on 18/10/2017.
 * @author Colin.
 */
public class HelloWorld {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

//        // 新增用户测试
//        Users user = new Users();
//        user.setUsername("colin");
//        user.setNickname("Colin Liu");
//        user.setPassword("passwordcolin");
//        user.setSex(1);
//        UserDao userdao = new UserDao();
//        userdao.addUser(user);

//        // 用户查询测试
//        Users users = new Users();
//        users.setUsername("colin");
//        UserDao userdao_get = new UserDao();
//        userdao_get.getUsers(users);

        // 删除用户测试
//        Users users = new Users();
//        users.setUsername("colin");
//        UserDao userdao_delete = new UserDao();
//        userdao_delete.deleteUsers(users);

        // 批量查询用户
        Users users = new Users();
        UserDao userDao = new UserDao();
        ArrayList userlist = userDao.getUsersList(users);
        System.out.println(userlist.size());

//        // update password
//        Users userupdate = new Users();
//        user.setUsername("colin");
//        user.setPassword("changepassword");
//        UserDao updatePasswd = new UserDao();
//        updatePasswd.updatePasswd(user);
    }
}
