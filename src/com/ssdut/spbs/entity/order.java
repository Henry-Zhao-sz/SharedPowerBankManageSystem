package com.ssdut.spbs.entity;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class order {

      private int orderID;//订单ID
      private int orderUserID;//订单创建者ID
      private String  orderLendLocID;//充电宝借出地点
      private int orderPbID;//订单使用的充电宝ID
      private Timestamp orderCreateTime;//订单创建时间
      private int orderHasFinished;//订单是否完成
      private String orderRevertLocID;//还充电宝地点
      private Timestamp orderFinishTime;//订单结束时间
      private double orderCost;//订单花费

      public int getOrderID() {
            return orderID;
      }

      public void setOrderID(int orderID) {
            this.orderID = orderID;
      }

      public int getOrderUserID() {
            return orderUserID;
      }

      public void setOrderUserID(int orderUserID) {
            this.orderUserID = orderUserID;
      }

      public String getOrderLendLocID() {
            return orderLendLocID;
      }

      public void setOrderLendLocID(String orderLendLocID) {
            this.orderLendLocID = orderLendLocID;
      }

      public int getOrderPbID() {
            return orderPbID;
      }

      public void setOrderPbID(int orderPbID) {
            this.orderPbID = orderPbID;
      }

      public Timestamp getOrderCreateTime() { 
    	  return orderCreateTime;
      }

      public void setOrderCreateTime(Timestamp orderCreateTime) {
    	  this.orderCreateTime = orderCreateTime;
      }

      public int getOrderHasFinished() {
            return orderHasFinished;
      }

      public void setOrderHasFinished(int orderHasFinished) {
            this.orderHasFinished = orderHasFinished;
      }

      public String getOrderRevertLocID() {
            return orderRevertLocID;
      }

      public void setOrderRevertLocID(String orderRevertLocID) {
            this.orderRevertLocID = orderRevertLocID;
      }

      public Timestamp getOrderFinishTime() {
            return orderFinishTime;
      }

      public void setOrderFinishTime(Timestamp orderFinishTime) {
            this.orderFinishTime = orderFinishTime;
      }

      public double getOrderCost() {
            return orderCost;
      }

      public void setOrderCost(double orderCost) {
            this.orderCost = orderCost;
      }
}
