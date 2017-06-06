package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by localhost on 17-6-6.
 */
public class GoddessDao {

    public void addGoddess(Goddess g) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql =""+"insert into imooc_goddess (user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel) values(?,?,?,?,?,?,?,CURRENT_DATE ,?,CURRENT_DATE ,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new java.sql.Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getCreate_user());
        ptmt.setString(8,g.getUpdate_user());
        ptmt.setInt(9,g.getIsdel());

        ptmt.execute();
    }

    public void updateGoddess(){

    }

    public void delGoddess(){

    }

    public List<Goddess> query() throws Exception {
        Connection conn = DBUtil.getConnection();

        //3.通过数据库的连接操纵数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM imooc_goddess");

        List<Goddess> gs = new ArrayList<Goddess>();
        Goddess g =null;

        while (rs.next()){
            g=new Goddess();
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);

        }

        return gs;
    }

    public Goddess get(){
        return null;
    }
}
