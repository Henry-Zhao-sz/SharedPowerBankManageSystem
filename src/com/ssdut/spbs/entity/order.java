package com.ssdut.spbs.entity;
import java.util.*;
public class order {

      private int orderID;
      private int orderUserID;
      private String  orderLendLocID;
      private int orderPbID;
      private Date orderCreateTime;
      private int orderHasFinished;
      private String orderRevertLocID;
      private Date orderFinishTime;
      private double orderCost;

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

      public Date getOrderCreateTime() {
            return orderCreateTime;
      }

      public void setOrderCreateTime(Date orderCreateTime) {
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

      public Date getOrderFinishTime() {
            return orderFinishTime;
      }

      public void setOrderFinishTime(Date orderFinishTime) {
            this.orderFinishTime = orderFinishTime;
      }

      public double getOrderCost() {
            return orderCost;
      }

      public void setOrderCost(double orderCost) {
            this.orderCost = orderCost;
      }
}
