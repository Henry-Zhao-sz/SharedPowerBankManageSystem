package com.ssdut.spbs.service;
import java.util.*;
import com.ssdut.spbs.entity.*;
public interface LocService {
    List<loc> showAllLoc();

    loc showSpeLoc(String lid);

    List<loc> showSpeRegion(String rid);

    boolean addLoc(loc loc1);

}
