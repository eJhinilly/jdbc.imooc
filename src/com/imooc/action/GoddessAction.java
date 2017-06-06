package com.imooc.action;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

import java.util.Date;

/**
 * Created by localhost on 17-6-6.
 */
public class GoddessAction {

    public static void main(String[] args) throws Exception {

        GoddessDao g = new GoddessDao();
        Goddess g1 = new Goddess();

        g1.setUser_name("小夏");
        g1.setSex(1);
        g1.setAge(22);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@imooc.com");
        g1.setMobile("18766685587");
        g1.setCreate_user("ADMIN");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);

        g.addGoddess(g1);

    }
}
