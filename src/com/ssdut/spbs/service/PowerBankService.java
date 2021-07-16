package com.ssdut.spbs.service;
import com.ssdut.spbs.entity.*;
import java.util.*;
public interface PowerBankService {

    List<powerbank> showAllPB();

    List<powerbank> showSpePB(String pb_loc);

    powerbank showPBWithID(int pb_id);

    int addPB(powerbank pb1);

    int updatePB();

    List<powerbank> showUpdatePB();

}
