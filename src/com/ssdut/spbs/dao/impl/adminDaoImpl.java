package com.ssdut.spbs.dao.impl;

import com.ssdut.spbs.dao.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminDaoImpl implements adminDao{
    @Override
    public admin queryByADnameAndADpass(String adname, String adpass){
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        admin admin1=null;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.prepareStatement("select * from admin where `adminName`=? and `adminPwd`=?" );
            st.setString(1, adname);
            st.setString(2, adpass);
            //System.out.println(st.toString());
            rs=st.executeQuery();
            while(rs.next()) {
                admin1=new admin();
                admin1.setAdminID(rs.getInt("adminID"));
                admin1.setAdminName(rs.getString("adminName"));
                admin1.setAdminPwd(rs.getString("adminPwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);
        }
        return admin1;
    }

}



