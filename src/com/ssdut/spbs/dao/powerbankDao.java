package com.ssdut.spbs.dao;

import com.ssdut.spbs.entity.*;

import java.util.List;

public interface powerbankDao {

    List<powerbank> showTheAllPB();

    List<powerbank> showTheSpePB(String pb_loc);

    powerbank showPBWithTheID(int pb_id);

    int savePB(powerbank pb1);


    //借出时更新充电宝信息
    boolean updatePowerbankInfoBorrow(int pdID);

}
