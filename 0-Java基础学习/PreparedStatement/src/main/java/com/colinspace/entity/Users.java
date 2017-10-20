package com.colinspace.entity;

/**
 * Created by colin on 19/10/2017.
 * @author Colin
 * users 用户实体类
 */
public class Users {
    // primary key
    private int uid;
    private String nickname;
    private String username;
    private String password;
    private int sex;

    public  Users(){}

    /**
     * 初始化
     * @param nickname
     * @param username
     * @param sex
     */
    public Users(String nickname,String username, String password, int sex){
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    /**
     * get/set 方法
     */

    public int getUid(){return  uid;}
    public void setUid(){ this.uid = uid;}

    public String getNickname(){return nickname;}
    public void  setNickname(String nickname){ this.nickname = nickname;}

    public String getUsername(){return  username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return  password;}
    public void setPassword(String password) { this.password = password;}

    public int getSex(){return sex;}
    public void setSex(int sex){ this.sex = sex;}
}
