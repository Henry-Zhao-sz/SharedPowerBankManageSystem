package com.ssdut.spbs.service.Impl;

import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.*;

public class BaseServiceImpl implements BaseService{

    userDaoImpl udi = new userDaoImpl();
    adminDaoImpl adi = new adminDaoImpl();
    @Override
    public user checkLogin(String uname, String upass) {
        user user1=udi.queryByUnameAndUpass(uname, upass);
        return user1;
    }

    @Override
    public admin checkAdminLogin(String adname, String adPwd){
        admin admin1=adi.queryByADnameAndADpass(adname,adPwd);
        return admin1;
    }

    @Override
    public boolean register(user user1) {
        return udi.saveUser(user1) > 0;
    }

}
