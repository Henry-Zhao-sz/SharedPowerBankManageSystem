package com.ssdut.spbs.dao;

import com.ssdut.spbs.entity.*;

import java.util.*;

public interface locDao {

    List<loc> listLoc();

    loc listSpeLoc(String lid);

    List<loc> listSpeRegion(String rid);

    String returnLocInfo(String locID);

    int saveLoc(loc loc1);

}
