package com.ssdut.spbs.service.Impl;

import com.ssdut.spbs.service.OrderService;
import java.util.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.dao.impl.*;

public class OrderServiceImpl implements OrderService {
      orderDaoImpl odi=new orderDaoImpl();  
	@Override
      public List <order> showAllOrder(){
    	  return odi.selectAllOrder();
      }
}
