package com.ssdut.spbs.service.Impl;

import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.*;



//基本服务实现
public class BaseServiceImpl implements BaseService{

    userDaoImpl udi = new userDaoImpl();//创建用户查询对象
    adminDaoImpl adi = new adminDaoImpl();//创建管理员查询对象
    @Override
    public user checkLogin(String uname, String upass) {//检查是否有该用户，没有返回null无法登录，若有则返回用户对象信息
        user user1=udi.queryByUnameAndUpass(uname, upass);
        return user1;//返回用户对象
    }

    @Override
    public admin checkAdminLogin(String adname, String adPwd){
        admin admin1=adi.queryByADnameAndADpass(adname,adPwd);//检查是否有该管理员，没有返回null无法登录，若有则返回管理员对象信息
        return admin1;
    }

    @Override
    public boolean register(user user1) {
        return udi.saveUser(user1) > 0;
    }//对用户进行注册

}
