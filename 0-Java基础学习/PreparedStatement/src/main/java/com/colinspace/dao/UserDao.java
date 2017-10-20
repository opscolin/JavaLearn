package com.colinspace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.colinspace.db.DbConn;
import com.colinspace.db.DbClose;

import com.colinspace.entity.Users;

/**
 * Created by colin on 19/10/2017.
 * @author colin
 */
public class UserDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 添加用户信息到数据库表
     * @param users
     * @return boolean
     */
    public boolean addUser(Users users){
        boolean bool = false;
        conn = DbConn.getconn();
        String sql = "insert into test_users(nickname, username, password, sex) values(?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, users.getNickname());
            pstmt.setString(2, users.getUsername());
            pstmt.setString(3, users.getPassword());
            pstmt.setInt(4, users.getSex());

            int rs = pstmt.executeUpdate();
            if (rs > 0){
                bool = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.addClose(pstmt, conn);
        }

        return bool;
    }


    public  boolean deleteUsers(Users users){
        boolean bool = false;
        conn = DbConn.getconn();
        String sql = "delete from test_users where username = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, users.getUsername());
            int rs = pstmt.executeUpdate();
            if (rs > 0){
                bool = true;
                System.out.println("delete user successfully!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.addClose(pstmt, conn);
        }
        return bool;
    }

    public String getUsers(Users users){
        String result = null;
        conn = DbConn.getconn();
        String sql = "select * from test_users where username = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, users.getUsername());


            rs = pstmt.executeQuery();
            while (rs.next()) {
                result = "the user information is: " + rs.getString("nickname");
                System.out.println(result);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.addClose(pstmt, conn);
        }

        return result;
    }

    public ArrayList getUsersList(Users users){
        ArrayList<Users> userslist = new ArrayList<Users>();
        Connection conn = DbConn.getconn();
        String sql = "select * from test_users";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String nickname = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                int sex = rs.getInt(5);
                userslist.add(users);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.addClose(pstmt, conn);
        }
        return  userslist;
    }

    public boolean updatePasswd(Users user){
        boolean bool = false;
        Connection conn = DbConn.getconn();
        String updatePasswd = "update test_users set password = ? where username = ?";
        try {
            pstmt = conn.prepareStatement(updatePasswd);
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getUsername());
            int rs = pstmt.executeUpdate();
            if (rs > 0){
                bool = true;
                System.out.println("update password successfully!");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbClose.addClose(pstmt, conn);
        }
        return  bool;
    }
}
