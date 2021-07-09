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
            conn = JdbcUtil.getConnection();//连接数据库
            //写出sql语句，将可变变量，用？做替代，进行预编译
            st = conn.prepareStatement("select * from admin where `adminName`=? and `adminPwd`=?" );
            //将参数进行替换
            st.setString(1, adname);
            st.setString(2, adpass);
            //System.out.println(st.toString());
            rs=st.executeQuery();//执行语句
            while(rs.next()) {//遍历查询结果
                admin1=new admin();
                admin1.setAdminID(rs.getInt("adminID"));
                admin1.setAdminName(rs.getString("adminName"));
                admin1.setAdminPwd(rs.getString("adminPwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(rs, st, conn);//关闭连接
        }
        return admin1;//返回查询出的结果对象
    }

}



