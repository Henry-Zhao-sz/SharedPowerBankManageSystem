package com.ssdut.spbs.service;

import java.util.*;
import com.ssdut.spbs.entity.*;

public interface UserService {

    List<user> showAllUser();

    user showSpeUser(int uid);

    int removeSpeUser(int uid);

    int changeMessage(String telephone, String name, String keyword);

    int returnTheMatch(String telephone);

    int topUp(double money, String name, String key);

    int topTheUp(String name, String key);

}
