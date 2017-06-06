package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by localhost on 17-6-6.
 */
public class goddessDao {

    public void addGoddess(){

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
