package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by localhost on 17-6-6.
 */
public class GoddessDao {

    public void addGoddess(Goddess g) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql =""+" insert into imooc_goddess (user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel) values(?,?,?,?,?,?,?,CURRENT_DATE ,?,CURRENT_DATE ,?) ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        //g.getBirthday()方法得到java.util.Date类型,需要转换成java.sql.Date类型
        ptmt.setDate(4,new java.sql.Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getCreate_user());
        ptmt.setString(8,g.getUpdate_user());
        ptmt.setInt(9,g.getIsdel());

        ptmt.execute();
    }

    public void updateGoddess(Goddess g) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql =""+" UPDATE imooc_goddess SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=CURRENT_DATE ,isdel=? WHERE id=? "+"";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new java.sql.Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getUpdate_user());
        ptmt.setInt(8,g.getIsdel());
        ptmt.setInt(9,g.getId());

        ptmt.execute();

    }

    public void delGoddess(Integer id) throws Exception{

        Connection conn = DBUtil.getConnection();
        String sql =""+"DELETE FROM imooc_goddess WHERE id=?"+"";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1,id);

        ptmt.execute();
    }

    public List<Goddess> query() throws Exception {
        List<Goddess> result = new ArrayList<Goddess>();

        Connection conn = DBUtil.getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append(" select id,user_name,age from imooc_goddess ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();

        Goddess g =null;

        while (rs.next()){
            g=new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            result.add(g);

        }

        return result;
    }

    public List<Goddess> query(String name,String mobile) throws Exception {
        List<Goddess> result = new ArrayList<Goddess>();

        Connection conn = DBUtil.getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append(" select * from imooc_goddess ");
        sb.append(" where user_name like ? and mobile like ? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1,"%"+name+"%");
        ptmt.setString(2,"%"+mobile+"%");

        ResultSet rs = ptmt.executeQuery();
        System.out.println(sb.toString());

        Goddess g =null;

        while (rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            //日期类型不用转换，因为java.sql.Date属于java.util.Date
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));

            result.add(g);
        }

        return result;
    }

    public List<Goddess> query(List<Map<String,Object>> params) throws Exception {
        List<Goddess> result = new ArrayList<Goddess>();

        Connection conn = DBUtil.getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append(" select * from imooc_goddess where 1=1 ");
        if(params!=null && params.size()>0){
            for (Map<String,Object> map : params
                 ) {
                sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
            }
        }


        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ResultSet rs = ptmt.executeQuery();
        System.out.println(sb.toString());

        Goddess g =null;

        while (rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            //日期类型不用转换，因为java.sql.Date属于java.util.Date
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));

            result.add(g);
        }

        return result;
    }

    public Goddess get(Integer id) throws SQLException{
        Goddess g =null;

        Connection conn = DBUtil.getConnection();

        String sql =""+" SELECT * FROM imooc_goddess WHERE id=?  ";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1,id);

        ResultSet rs = ptmt.executeQuery();



        while (rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            //日期类型不用转换，因为java.sql.Date属于java.util.Date
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));

        }

        return g;
    }
}
