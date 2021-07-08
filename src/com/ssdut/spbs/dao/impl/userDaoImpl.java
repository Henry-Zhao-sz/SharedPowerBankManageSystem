package com.ssdut.spbs.dao.impl;

import com.ssdut.spbs.dao.userDao;
import com.ssdut.spbs.entity.user;
import com.ssdut.spbs.util.JdbcUtil;

import java.util.*;
import java.sql.*;

public class userDaoImpl implements userDao {
    @Override
    public user queryByUnameAndUpass(String uname, String upass) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        user user1=null;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.prepareStatement("select * from user where `userName`=? and `userPwd`=?" );
            st.setString(1, uname);
            st.setString(2, upass);
            //System.out.println(st.toString());
            rs=st.executeQuery();
            while(rs.next()) {
                user1=new user();
                user1.setUserID(rs.getInt("userID"));
                user1.setUserName(rs.getString("userName"));
                user1.setUserPwd(rs.getString("userPwd"));
                user1.setUserPhone(rs.getString("userPhone"));
                user1.setUseTimes(rs.getInt("useTimes"));
                user1.setUseTimeLong(rs.getTime("useTimeLong"));
                user1.setUseTimesLocA(rs.getInt("useTimesLocA"));
                user1.setUseTimesLocB(rs.getInt("useTimesLocB"));
                user1.setUseTimesLocC(rs.getInt("useTimesLocC"));
                user1.setUseTimesLocD(rs.getInt("useTimesLocD"));
                user1.setUserBalance(rs.getDouble("userBalance"));
                user1.setUserDiscount(rs.getDouble("userDiscount"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return user1;
    }

    @Override
    public int saveUser(user user1) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int affectedRow = 0;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.prepareStatement("insert into user(userID,userName,userPwd,userPhone,useTimes,useTimeLong,useTimesLocA,useTimesLocB,useTimesLocC,useTimesLocD,userBalance,userDiscount) values(?,?,?,?,0,0,0,0,0,0,100,1)");
            st.setInt(1,user1.getUserID());
            st.setString(2, user1.getUserName());
            st.setString(3, user1.getUserPwd());
            st.setString(4,user1.getUserPhone());
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
    public List<user> listUser() {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List <user> list=new ArrayList<user>();
        user user1=null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from user");
            rs=st.executeQuery();
            while(rs.next()) {
                user1=new user();
                user1.setUserID(rs.getInt("userID"));
                user1.setUserName(rs.getString("userName"));
                user1.setUserPwd(rs.getString("userPwd"));
                user1.setUserPhone(rs.getString("userPhone"));
                user1.setUseTimes(rs.getInt("useTimes"));
                user1.setUseTimeLong(rs.getTime("useTimeLong"));
                user1.setUseTimesLocA(rs.getInt("useTimesLocA"));
                user1.setUseTimesLocB(rs.getInt("useTimesLocB"));
                user1.setUseTimesLocC(rs.getInt("useTimesLocC"));
                user1.setUseTimesLocD(rs.getInt("useTimesLocD"));
                user1.setUserBalance(rs.getDouble("userBalance"));
                user1.setUserDiscount(rs.getDouble("userDiscount"));
                list.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return list;
    }

    @Override
    public user listSpeUser(int uid) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        user user1=null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st=conn.prepareStatement("select * from user where `userID` = ? ");
            st.setInt(1,uid);
            rs=st.executeQuery();
            while(rs.next()) {
                user1=new user();
                user1.setUserID(rs.getInt("userID"));
                user1.setUserName(rs.getString("userName"));
                user1.setUserPwd(rs.getString("userPwd"));
                user1.setUserPhone(rs.getString("userPhone"));
                user1.setUseTimes(rs.getInt("useTimes"));
                user1.setUseTimeLong(rs.getTime("useTimeLong"));
                user1.setUseTimesLocA(rs.getInt("useTimesLocA"));
                user1.setUseTimesLocB(rs.getInt("useTimesLocB"));
                user1.setUseTimesLocC(rs.getInt("useTimesLocC"));
                user1.setUseTimesLocD(rs.getInt("useTimesLocD"));
                user1.setUserBalance(rs.getDouble("userBalance"));
                user1.setUserDiscount(rs.getDouble("userDiscount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return user1;
    }

    @Override
    public int deleteSpeUser(int uid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int affectedRow = 0;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("delete from user where userID=?");
            st.setInt(1, uid);
            affectedRow=st.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return affectedRow;
    }

}

