package com.imooc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc";
    private static final String USER="root";
    private static final String PASSWORD="123456";

    public static void main(String[] args) throws Exception {
	// write your code here
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        //3.通过数据库的连接操纵数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM imooc_goddess");

        while (rs.next()){
            System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
        }
    }
}
