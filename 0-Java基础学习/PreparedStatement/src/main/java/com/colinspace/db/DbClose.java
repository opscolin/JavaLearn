package com.colinspace.db;

import java.sql.*;


/**
 * Created by colin on 19/10/2017.
 * @author Colin
 * 配置数据库关闭
 */
public class DbClose {
    /**
     * @param pstmt, rs, conn
     */
    public static void addClose(PreparedStatement pstmt, Connection conn) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn) {
        try {
            if (pstmt !=null){
                pstmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
