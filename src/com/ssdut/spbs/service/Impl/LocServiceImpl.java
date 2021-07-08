package com.ssdut.spbs.service.Impl;

import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.LocService;
import com.ssdut.spbs.dao.impl.*;

import java.util.List;


public class LocServiceImpl implements LocService {

    locDaoImpl ldi = new locDaoImpl();

    @Override
    public List<loc> showAllLoc() {
        List<loc> list=ldi.listLoc();
        return list;
    }

    @Override
    public loc showSpeLoc(String lid){
        loc loc1 = ldi.listSpeLoc(lid);
        return loc1;
    }

    @Override
    public List<loc> showSpeRegion(String rid){
        List<loc> list = ldi.listSpeRegion(rid);
        return list;
    }

    @Override
    public boolean addLoc(loc loc1){
        return ldi.saveLoc(loc1)>0;
    }

}
