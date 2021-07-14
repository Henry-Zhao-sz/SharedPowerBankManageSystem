package com.ssdut.spbs.dao;

import com.ssdut.spbs.entity.*;

import java.util.*;

public interface locDao {

    List<loc> listLoc();

    loc listSpeLoc(String lid);

    List<loc> listSpeRegion(String rid);

    int saveLoc(loc loc1);

    /*输入站点ID
    查询当前站点可用的充电宝
    返回充电宝列表
     */

    List<powerbank> showPowerBank(String locID);

}
