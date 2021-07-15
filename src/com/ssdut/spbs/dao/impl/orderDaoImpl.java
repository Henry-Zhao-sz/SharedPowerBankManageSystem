package com.ssdut.spbs.dao.impl;

import com.ssdut.spbs.dao.orderDao;
import com.ssdut.spbs.entity.loc;
import com.ssdut.spbs.entity.order;
import com.ssdut.spbs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class orderDaoImpl implements orderDao {

    @Override
    public order queryByOrderID(int orderID) {//根据订单号查询订单
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        order order1=null;
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            st = conn.prepareStatement("select * from `order` where `orderID`=?" );
            //将参数进行替换
            st.setInt(1, orderID);
            //System.out.println(st.toString());
            rs=st.executeQuery();//执行语句
            while(rs.next()) {//遍历查询结果
                order1=new order();
                order1.setOrderID(rs.getInt("orderID"));
                order1.setOrderUserID(rs.getInt("orderUserID"));
                order1.setOrderLendLocID(rs.getString("orderLendLocID"));
                order1.setOrderPbID(rs.getInt("orderPbID"));
                order1.setOrderCreateTime(rs.getTimestamp("orderCreateTime"));
                order1.setOrderHasFinished(rs.getInt("orderHasFinished"));
                order1.setOrderLendLocID(rs.getString("orderLendLocID"));
                order1.setOrderRevertLocID(rs.getString("orderRevertLocID"));
                order1.setOrderFinishTime(rs.getTimestamp("orderFinishTime"));
                order1.setOrderCost(rs.getDouble("orderCost"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);//关闭连接
        }
        return order1;//返回查询出的结果对象
    }


    @Override
    public List<order> queryByUserID(int orderUserID)//查询单个用户所有订单
    {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        order order1=null;
        List <order> list=new ArrayList<order>();
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            st = conn.prepareStatement("select * from `order` where `orderUserID`=?" );
            //将参数进行替换
            st.setInt(1, orderUserID);
            //System.out.println(st.toString());
            rs=st.executeQuery();//执行语句
            while(rs.next()) {//遍历查询结果
                order1=new order();
                order1.setOrderID(rs.getInt("orderID"));
                order1.setOrderUserID(rs.getInt("orderUserID"));
                order1.setOrderLendLocID(rs.getString("orderLendLocID"));
                order1.setOrderPbID(rs.getInt("orderPbID"));
                order1.setOrderCreateTime(rs.getTimestamp("orderCreateTime"));
                order1.setOrderHasFinished(rs.getInt("orderHasFinished"));
                order1.setOrderLendLocID(rs.getString("orderLendLocID"));
                order1.setOrderRevertLocID(rs.getString("orderRevertLocID"));
                order1.setOrderFinishTime(rs.getTimestamp("orderFinishTime"));
                order1.setOrderCost(rs.getDouble("orderCost"));
                list.add(order1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);//关闭连接
        }
        return list;//返回该用户的所有的订单的列表
    }


    @Override
    public double querySumCostByUserID(int orderUserID)//查询用户所花费总金额
    {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Double Cost=0.0;
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            st = conn.prepareStatement("select sum(orderCost) from `order` where `orderUserID`=? group by `orderUserID`");
            //将参数进行替换
            st.setInt(1, orderUserID);
            //System.out.println(st.toString());
            rs=st.executeQuery();//执行语句
            while(rs.next()) {//遍历查询结果
                Cost = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);//关闭连接
        }
        return Cost;//返回该用户的所有的订单的列表
    }
    
    @Override
    public List<order> selectAllOrder(){
    	// TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <order> list=new ArrayList<order>();
        order order1=null;
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from `order`");
            rs=st.executeQuery();
            while(rs.next()) {//执行语句，遍历查询结果
            	order1=new order();
                order1.setOrderID(rs.getInt("orderID"));
                order1.setOrderUserID(rs.getInt("orderUserID"));
                order1.setOrderLendLocID(rs.getString("orderLendLocID"));
                order1.setOrderPbID(rs.getInt("orderPbID"));
                order1.setOrderCreateTime(rs.getTimestamp("orderCreateTime"));
                order1.setOrderHasFinished(rs.getInt("orderHasFinished"));
                order1.setOrderLendLocID(rs.getString("orderLendLocID"));
                order1.setOrderRevertLocID(rs.getString("orderRevertLocID"));
                order1.setOrderFinishTime(rs.getTimestamp("orderFinishTime"));
                order1.setOrderCost(rs.getDouble("orderCost"));
                list.add(order1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }
    
}




