package com.ssdut.spbs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class powerbankDaoImpl implements powerbankDao {

    @Override
    public List<powerbank> showTheAllPB(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <powerbank> list=new ArrayList<powerbank>();
        powerbank pb1=null;
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            st=conn.prepareStatement("select * from powerbank");
            rs=st.executeQuery();
            while(rs.next()) {//执行语句，遍历查询结果
                pb1=new powerbank();
                pb1.setPbID(rs.getInt("pbID"));
                pb1.setBlState(rs.getInt("BlState"));
                pb1.setRestPower(rs.getDouble("restPower"));
                pb1.setUseTimeLong(rs.getTime("useTimeLong"));
                pb1.setPbLoc(rs.getString("pbLoc"));
                pb1.setHealthState(rs.getDouble("HealthState"));
                list.add(pb1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }

    @Override
    public List<powerbank> showTheSpePB(String pb_loc){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <powerbank> list=new ArrayList<powerbank>();
        powerbank pb1=null;
        try {
            conn = JdbcUtil.getConnection();

            st=conn.prepareStatement("select * from powerbank where `pbLoc` like ?");
            st.setString(1,"%" + pb_loc + "%");
            rs=st.executeQuery();
            while(rs.next()) {
                pb1=new powerbank();
                pb1.setPbID(rs.getInt("pbID"));
                pb1.setBlState(rs.getInt("BlState"));
                pb1.setRestPower(rs.getDouble("restPower"));
                pb1.setUseTimeLong(rs.getTime("useTimeLong"));
                pb1.setPbLoc(rs.getString("pbLoc"));
                pb1.setHealthState(rs.getDouble("HealthState"));
                list.add(pb1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }

    @Override
    public powerbank showPBWithTheID(int pb_id){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <powerbank> list=new ArrayList<powerbank>();
        powerbank pb1=null;
        try {
            conn = JdbcUtil.getConnection();
            st=conn.prepareStatement("select * from powerbank where `pbID` = ? ");
            st.setInt(1,pb_id);
            rs=st.executeQuery();
            while(rs.next()) {
                pb1=new powerbank();
                pb1.setPbID(rs.getInt("pbID"));
                pb1.setBlState(rs.getInt("BlState"));
                pb1.setRestPower(rs.getDouble("restPower"));
                pb1.setUseTimeLong(rs.getTime("useTimeLong"));
                pb1.setPbLoc(rs.getString("pbLoc"));
                pb1.setHealthState(rs.getDouble("HealthState"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return pb1;
    }

    @Override
    public int savePB(powerbank pb1){
        Connection conn = null;
        PreparedStatement st = null;
        PreparedStatement st1=null;
        ResultSet rs = null;
        int affectedRow = 0;
        powerbank pbx=this.showPBWithTheID(pb1.getPbID());
        if(pbx!=null){
            return -1;
        }
        try {
            conn = JdbcUtil.getConnection();
            st = conn.prepareStatement("insert into powerbank(pbID,blState,restPower,useTimeLong,pbLoc,HealthState) values(?,?,?,?,?,?)");
            st.setInt(1,pb1.getPbID());
            st.setInt(2,pb1.getBlState());
            st.setDouble(3,pb1.getRestPower());
            st.setTime(4,pb1.getUseTimeLong());
            st.setString(5,pb1.getPbLoc());
            st.setDouble(6,pb1.getHealthState());
            affectedRow = st.executeUpdate();
            st=conn.prepareStatement("update loc set `availNum`=`availNum`+1 where `locID`=?");
            st.setString(1,pb1.getPbLoc());
            affectedRow = st.executeUpdate();
            st1=conn.prepareStatement("update loc set `totalNum`=`totalNum`+1 where `locID`=?");
            st1.setString(1,pb1.getPbLoc());
            affectedRow = st1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
            JdbcUtil.closeAll(rs, st1, conn);
        }
        return affectedRow;
    }


    @Override
    public int updateThePB(){
        Connection conn=null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int match=0;
        try{
            conn=JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st=conn.prepareStatement("select count(*) from powerbank where `HealthState`<30");
            rs=st.executeQuery();
            if(rs.next()){
                st=conn.prepareStatement("update powerbank set `HealthState`=100 where `HealthState`<30");
                match=st.executeUpdate();
                conn.commit();
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
        return match;
    }


    @Override
    public List<powerbank> showTheUpdatePB(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <powerbank> list=new ArrayList<powerbank>();
        powerbank pb1=null;
        try {
            conn = JdbcUtil.getConnection();//连接数据库
            st=conn.prepareStatement("select * from powerbank where `HealthState`<30");
            rs=st.executeQuery();
            while(rs.next()) {//执行语句，遍历查询结果
                pb1=new powerbank();
                pb1.setPbID(rs.getInt("pbID"));
                pb1.setBlState(rs.getInt("BlState"));
                pb1.setRestPower(rs.getDouble("restPower"));
                pb1.setUseTimeLong(rs.getTime("useTimeLong"));
                pb1.setPbLoc(rs.getString("pbLoc"));
                pb1.setHealthState(rs.getDouble("HealthState"));
                list.add(pb1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }

}
