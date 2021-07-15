package com.ssdut.spbs.service.Impl;


import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.*;

import java.util.Date;
import java.util.List;


public class UserServiceImpl implements UserService {

      userDaoImpl udi=new userDaoImpl();

      @Override
      public List<user> showAllUser() {
          List<user> list=udi.listUser();
          return list;
    }

    @Override
    public user showSpeUser(int uid){
          user user1=udi.listSpeUser(uid);
          return user1;
    }

    @Override
    public int removeSpeUser(int uid){
          return udi.deleteSpeUser(uid);
    }

    @Override//参数： 用户ID,借出地点，订单创建时间
    public boolean createOrder(int uid, String lendLocID, int pdID, long orderCreateTime)
    {
        user user1 = udi.listSpeUser(uid);//获取当前用户全部信息
        order order1 = new order();//创建订单对象
        orderDaoImpl odi = new orderDaoImpl();//订单管理
        //设置订单参数
        order1.setOrderID(odi.findOrderNum()+1);//设置订单编号
        order1.setOrderUserID(user1.getUserID());//设置使用者ID
        order1.setOrderLendLocID(lendLocID);//设置订单借出地点
        order1.setOrderPbID(pdID);//订单使用充电宝ID
        order1.setOrderCreateTime(orderCreateTime);//订单创建时间

        if(odi.CreateOrder(order1)==1)
        {
            //创建订单成功
            System.out.println("创建订单成功");
            return  true;
        }
        else
        {
            //创建订单失败
            System.out.println("创建订单失败");
            return false;
        }
    }



}
