package com.ssdut.spbs.service;

import java.util.*;
import com.ssdut.spbs.entity.*;

public interface UserService {

    List<user> showAllUser();

    user showSpeUser(int uid);

    int removeSpeUser(int uid);
    //创建订单
    boolean createOrder(int uid, String lendLocID, int pdID,long orderCreateTime);
    //完成订单


}
