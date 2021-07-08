package com.ssdut.spbs.service;

import com.ssdut.spbs.entity.*;

public interface BaseService {
    /**
     * 登录
     * @param uname 用户名
     * @param upass 密码
     * @return 成功返回User，失败返回null
     */
    user checkLogin(String uname,String upass);
    /**
     * 注册用户
     * @param user1 用户对象
     * @return 成功返回true，失败返回false
     */
    boolean register(user user1);

    admin checkAdminLogin(String adname, String adPwd);

}
