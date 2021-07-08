package com.ssdut.spbs.dao.impl;
import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from loc");
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


}
