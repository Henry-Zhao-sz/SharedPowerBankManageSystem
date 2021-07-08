package com.ssdut.spbs.service.Impl;


import com.ssdut.spbs.dao.impl.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.*;

import java.util.List;

public class UserServiceImpl implements UserService {

      userDaoImpl udi=new userDaoImpl();

      @Override
      public List<user> showAllUser() {
          List<user> list=udi.listUser();
          return list;
    }

    @Override
    public user showSpeUser(int uid){
          user user1=udi.listSpeUser(uid);
          return user1;
    }

    @Override
    public int removeSpeUser(int uid){
          return udi.deleteSpeUser(uid);
    }

}
