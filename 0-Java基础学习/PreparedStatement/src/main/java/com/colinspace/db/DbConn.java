package com.colinspace.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;


/**
 * Created by colin on 19/10/2017.
 * @author Colin
 * 配置连接MySQL数据库
 */
public class DbConn {
    public static Connection getconn(){
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/colinspace";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed()) {
                System.out.println("Succeeded connecting to the database!");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
