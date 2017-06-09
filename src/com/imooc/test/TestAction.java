package com.imooc.test;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

import java.util.*;

/**
 * Created by localhost on 17-6-7.
 */
public class TestAction {
    public static void main(String[] args) throws Exception{
        GoddessAction action = new GoddessAction();

        Goddess g = new Goddess();
        g.setUser_name("小青1");
        g.setSex(1);
        g.setAge(25);
        g.setBirthday(new Date());
        g.setEmail("xiaoqing@163.com");
        g.setMobile("15646464458");
        g.setIsdel(0);
        g.setId(7);

//        action.add(g);
//        action.edit(g);
//        action.del(7);

        List<Map<String,Object>> params = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name","user_name");
        map.put("rela","=");
        map.put("value","'小美'");
        params.add(map);

        //查询全部goddess

        List<Goddess> result = action.query(params);

        for (Goddess goddess:result
                ) {
            System.out.println(goddess.getId()+":"+goddess.getUser_name()+" 年龄为："+goddess.getAge()+"岁");
        }
    }
}
