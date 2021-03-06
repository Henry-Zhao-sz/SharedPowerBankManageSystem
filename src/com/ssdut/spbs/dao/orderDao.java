package com.ssdut.spbs.dao;

import com.ssdut.spbs.entity.*;

import java.util.List;

public interface orderDao {
    /**
     * 根据订单ID查询订单信息
     * @param orderID
     * @return 数据表中有一条记录返回一个order对象，否则返回null
     */
     order queryByOrderID(int orderID);


    /**
     * 根据用户ID查询用户所有订单信息
     * @param orderUserID
     * @return 数据表中有一条记录返回一个order列表对象，否则返回null
     */
    List<order> queryByUserID(int orderUserID);


    /**
     * 根据用户ID查询用户订单
     * @param orderUserID 根据用户ID查询所有订单花费
     * @return 数据表中有一条记录返回一个double列表，否则返回null
     */
    double querySumCostByUserID(int orderUserID);

    /**
     * 创建订单
     */

    int CreateOrder(order order1);

    /**
     * 找到订单编号
     *
     */
    int findOrderNum();

}
