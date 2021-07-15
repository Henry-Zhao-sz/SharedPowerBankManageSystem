package com.ssdut.spbs.service.Impl;

import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.PowerBankService;
import com.ssdut.spbs.dao.impl.*;

import java.util.List;

public class PowerBankServiceImpl implements PowerBankService {

    powerbankDaoImpl pbi = new powerbankDaoImpl();

    @Override
    public List<powerbank> showAllPB() {
        List<powerbank> list=pbi.showTheAllPB();
        return list;
    }

    @Override
    public List<powerbank> showSpePB(String pb_loc){
        List<powerbank> list=pbi.showTheSpePB(pb_loc);
        return list;
    }

    @Override
    public powerbank showPBWithID(int pb_id){
        powerbank list=pbi.showPBWithTheID(pb_id);
        return list;
    }

    @Override
    public int addPB(powerbank pb1){
        powerbankDaoImpl pbls = new powerbankDaoImpl();
        return pbls.savePB(pb1);
    }

}
