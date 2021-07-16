package com.ssdut.spbs.dao.impl;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class locDaoImpl implements locDao{

    @Override
    public List<loc> listLoc() {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <loc> list=new ArrayList<loc>();
        loc loc1=null;
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from loc");
            rs=st.executeQuery();
            while(rs.next()) {//执行语句，遍历查询结果
                loc1=new loc();
                loc1.setLocID(rs.getString("locID"));
                loc1.setLocInfo(rs.getString("locInfo"));
                loc1.setAvailNum(rs.getInt("availNum"));
                loc1.setTotalNum(rs.getInt("totalNum"));
                loc1.setMaxVolume(rs.getInt("maxVolume"));
                loc1.setLendTime(rs.getInt("lendTime"));
                list.add(loc1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }

    @Override
    public loc listSpeLoc(String lid){
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        loc loc1=null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from loc where `locID` = ? ");
            st.setString(1,lid);
            rs=st.executeQuery();
            while(rs.next()) {
                loc1=new loc();
                loc1.setLocID(rs.getString("locID"));
                loc1.setLocInfo(rs.getString("locInfo"));
                loc1.setAvailNum(rs.getInt("availNum"));
                loc1.setTotalNum(rs.getInt("totalNum"));
                loc1.setMaxVolume(rs.getInt("maxVolume"));
                loc1.setLendTime(rs.getInt("lendTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return loc1;

    }

    @Override
    public List<loc> listSpeRegion(String rid){
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <loc> list=new ArrayList<loc>();
        loc loc1=null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from loc where `locID` like '" +rid+"%'" );
            rs=st.executeQuery();
            while(rs.next()) {
                loc1=new loc();
                loc1.setLocID(rs.getString("locID"));
                loc1.setLocInfo(rs.getString("locInfo"));
                loc1.setAvailNum(rs.getInt("availNum"));
                loc1.setTotalNum(rs.getInt("totalNum"));
                loc1.setMaxVolume(rs.getInt("maxVolume"));
                loc1.setLendTime(rs.getInt("lendTime"));
                list.add(loc1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }

    @Override
    public int saveLoc(loc loc1){
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int affectedRow = 0;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.prepareStatement("insert into loc(locID,locInfo,availNum,totalNum,maxVolume,lendTime) values(?,?,?,?,?,0)");
            st.setString(1,loc1.getLocID());
            st.setString(2, loc1.getLocInfo());
            st.setInt(3, loc1.getAvailNum());
            st.setInt(4,loc1.getTotalNum());
            st.setInt(5,loc1.getMaxVolume());
            //System.out.println(st.toString());
			/*st.setInt(3, user.getState());
			st.setInt(4, user.getFlag());*/
            affectedRow = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return affectedRow;
    }

    @Override
    public String returnLocInfo(String locID){
        Connection conn=null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String locInfo=null;
        try{
            conn=JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st=conn.prepareStatement("select * from loc where locID=?");
            st.setString(1,locID);
            rs=st.executeQuery();
            if(rs.next()) {
                locInfo = rs.getString("locInfo");
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return locInfo;
    }



    @Override
    public List<powerbank> showPowerBank(String locID)
    {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <powerbank> list=new ArrayList<powerbank>();//创建充电宝列表
        powerbank pw=null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from powerbank where pbLoc like ?");
            st.setString(1,locID);//查询对应位置的所有充电宝
            rs=st.executeQuery();
            while(rs.next()) {
                pw=new powerbank();
                pw.setPbID(rs.getInt("pbID"));
                pw.setBlState(rs.getInt("blState"));
                pw.setRestPower(rs.getInt("restPower"));
                pw.setUseTimeLong(rs.getTime("useTimeLong"));
                pw.setPbLoc(rs.getString("pbLoc"));
                pw.setHealthState(rs.getDouble("HealthState"));
                list.add(pw);//列表加入充电宝
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;//返回列表
    }


    //订单借出后，更新位置信息
    public boolean updateLocInfo(String lendLocID)
    {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        powerbank pw=null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            //判断是否能借出
            st=conn.prepareStatement("update loc set availNum=availNum-1,lendTime=lendTime+1 where locID=?");
            st.setString(1,lendLocID);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return true;//修改成功
    }





}
