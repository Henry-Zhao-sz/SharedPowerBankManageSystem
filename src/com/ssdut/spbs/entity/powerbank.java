package com.ssdut.spbs.entity;
import java.sql.Time;
import java.util.*;

public class powerbank {

    private int pbID;      //充电宝编号
    private int blState;   //借用状态
    private double restPower;    //剩余电量
    private Time useTimeLong;    //使用时长
    private String pbLoc;        //充电宝位置
    private double HealthState;  //电池的健康状态

    public powerbank(int pbID, int blState, double restPower, Time useTimeLong, String pbLoc, double healthState) {
		this.pbID = pbID;
		this.blState = blState;
		this.restPower = restPower;
		this.useTimeLong = useTimeLong;
		this.pbLoc = pbLoc;
		HealthState = healthState;
	}

    public powerbank() {
    	pbID=200;
    	blState = 1;
    	restPower = 100;
        pbLoc = "A1";
    	HealthState = 100;
    	
    }
    
	public int getPbID() {
        return pbID;
    }

    public void setPbID(int pbID) {
        this.pbID = pbID;
    }

    public int getBlState() {
        return blState;
    }

    public void setBlState(int blState) {
        this.blState = blState;
    }

    public double getRestPower() {
        return restPower;
    }

    public void setRestPower(double restPower) {
        this.restPower = restPower;
    }

    public Time getUseTimeLong() {
        
    	return useTimeLong;
    }

    public void setUseTimeLong(Time useTimeLong) {
        this.useTimeLong = useTimeLong;
    }

    public String getPbLoc() {
        return pbLoc;
    }

    public void setPbLoc(String pbLoc) {
        this.pbLoc = pbLoc;
    }

    public double getHealthState() {
        return HealthState;
    }

    public void setHealthState(double healthState) {
        HealthState = healthState;
    }
}
