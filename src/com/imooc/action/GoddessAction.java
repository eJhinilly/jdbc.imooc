package com.imooc.action;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

import java.util.List;
import java.util.Map;

/**
 * Created by localhost on 17-6-6.
 */
public class GoddessAction {

    public void add(Goddess goddess) throws Exception{
        GoddessDao dao = new GoddessDao();

        goddess.setSex(1);
        goddess.setCreate_user("ADMIN");
        goddess.setUpdate_user("ADMIN");
        goddess.setIsdel(0);

        dao.addGoddess(goddess);
    }

    public void edit(Goddess goddess) throws Exception{
        GoddessDao dao = new GoddessDao();
        dao.updateGoddess(goddess);
    }

    public void del(Integer id) throws Exception{
        GoddessDao dao = new GoddessDao();
        dao.delGoddess(id);
    }

    public List<Goddess> query() throws Exception{
        GoddessDao dao = new GoddessDao();
        return dao.query();
    }

    public List<Goddess> query(List<Map<String,Object>> params) throws Exception {
        GoddessDao dao = new GoddessDao();
        return dao.query(params);
    }

    public Goddess get(Integer id) throws Exception{
        GoddessDao dao = new GoddessDao();
        return dao.get(id);
    }

    public static void main(String[] args){


    }
}
