package com.ssdut.spbs.dao;

import java.util.List;
import com.ssdut.spbs.entity.*;


public interface userDao {

    /**
     * 根据用户名和密码查询
     * @param uname
     * @param upass
     * @return 数据表中有一条记录返回一个user对象，否则返回null
     */
    user queryByUnameAndUpass(String uname,String upass);
    /**
     * 保存一个用户对象
     * @param user1
     * @return 返回受影响行数
     */
    int saveUser(user user1);


    List<user> listUser();

    user listSpeUser(int uid);

    int deleteSpeUser(int uid);



}
