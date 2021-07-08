package com.ssdut.spbs.dao;

import com.ssdut.spbs.entity.*;

public interface adminDao {

    /**
     * 根据用户名和密码查询
     * @param adname
     * @param adpass
     * @return 数据表中有一条记录返回一个user对象，否则返回null
     */
    admin queryByADnameAndADpass(String adname, String adpass);

}
