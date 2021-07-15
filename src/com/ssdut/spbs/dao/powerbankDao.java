package com.ssdut.spbs.dao;

import com.ssdut.spbs.entity.*;

import java.util.List;

public interface powerbankDao {

    List<powerbank> showTheAllPB();

    List<powerbank> showTheSpePB(String pb_loc);

    powerbank showPBWithTheID(int pb_id);

    int savePB(powerbank pb1);

    int updateThePB();

    List<powerbank> showTheUpdatePB();

}
