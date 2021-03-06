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
        user user1 = null;
        try {
            conn = JdbcUtil.getConnection(); //连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            st = conn.prepareStatement("select * from user where `userName`=? and `userPwd`=?");
            st.setString(1, uname);
            st.setString(2, upass);
            //System.out.println(st.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                user1 = new user();
                //获取查询用户全部信息
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
        return user1;//返回查询获得的用户对象
    }

    @Override
    public int queryByUid(int uid) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int match = 0;
        try {
            conn = JdbcUtil.getConnection(); //连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            st = conn.prepareStatement("select * from user where `userID` = ?");
            st.setInt(1, uid);
            //System.out.println(st.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                match++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return match;//返回查询获得的用户对象
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
            st.setInt(1, user1.getUserID());
            st.setString(2, user1.getUserName());
            st.setString(3, user1.getUserPwd());
            st.setString(4, user1.getUserPhone());
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
        List<user> list = new ArrayList<user>();
        user user1 = null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st = conn.prepareStatement("select * from user");
            rs = st.executeQuery();
            while (rs.next()) {
                user1 = new user();
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
        user user1 = null;
        try {
            conn = JdbcUtil.getConnection();
            //st = conn.prepareStatement("select * from topic");
            st = conn.prepareStatement("select * from user where `userID` = ? ");
            st.setInt(1, uid);
            rs = st.executeQuery();
            while (rs.next()) {
                user1 = new user();
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
    public int deleteSpeUser(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int affectedRow = 0;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("delete from user where userID=?");
            st.setInt(1, uid);
            affectedRow = st.executeUpdate();
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

    @Override
    public int changeTheMessage(String telephone, String name, String keyword) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int match = 0;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select * from user where userPhone=?");
            st.setString(1, telephone);
            rs = st.executeQuery();
            if (rs.next()) {
                st = conn.prepareStatement("update user set userName=?, userPwd=? where userPhone=?");
                st.setString(1, name);
                st.setString(2, keyword);
                st.setString(3, telephone);
                match = st.executeUpdate();
                conn.commit();
            }
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
        return match;
    }

    @Override
    public int returnMatch(String telephone) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int match = 0;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select * from user where userPhone=?");
            st.setString(1, telephone);
            rs = st.executeQuery();
            while (rs.next()) {
                match = rs.getRow();
            }
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
        return match;
    }

    @Override
    public int top_Up(double money, String name, String key) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int match = 0;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select * from user where userName=? and userPwd=?");
            st.setString(1, name);
            st.setString(2, key);
            rs = st.executeQuery();
            if (rs.next()) {
                st = conn.prepareStatement("update user set userBalance=userBalance+?");
                st.setDouble(1, money);
                match = st.executeUpdate();
                conn.commit();
            }
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
        return match;
    }

    @Override
    public int topThe_Up(String name, String key) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int match = 0;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select * from user where userName=? and userPwd=?");
            st.setString(1, name);
            st.setString(2, key);
            rs = st.executeQuery();
            while (rs.next()) {
                match = rs.getRow();
            }
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
        return match;
    }


    @Override
    public boolean updateTimes(int uid,String loc)
    {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String a ="A";
        if(loc.contains("A"))
        {
            a="useTimesLocA";
        }
        else if (loc.contains("B"))
        {
            a="useTimesLocB";
        }
        else if(loc.contains("C"))
        {
            a="useTimesLocC";
        }
        else if(loc.contains("D"))
        {
            a="useTimesLocD";
        }
        try {
            conn = JdbcUtil.getConnection();
            st = conn.prepareStatement("update user set useTimes=useTimes+1,"+a+"="+a+"+1 where userID =?;");
            st.setInt(1,uid);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return true;

    }
}


