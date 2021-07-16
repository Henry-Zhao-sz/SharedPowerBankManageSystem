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

    int queryByUid(int uid);

    List<user> listUser();

    //根据用户ID查询用户信息。
    user listSpeUser(int uid);

    int deleteSpeUser(int uid);

    //更新用户数据库中的借用次数
    boolean updateTimes(int uid,String loc);

    int changeTheMessage(String telephone, String name, String keyword);

    int returnMatch(String telephone);

    int top_Up(double money, String name, String key);

    int topThe_Up(String name, String key);




}
