package com.ssdut.spbs.entity;
import java.sql.Time;
import java.util.*;
public class user {

    private int userID;
    private String userName;
    private String userPwd;
    private String userPhone;
    private int useTimes;

    private Time useTimeLong;
    private int useTimesLocA;
    private int UseTimesLocB;
    private int useTimesLocC;
    private int useTimesLocD;
    private double userBalance;
    private double userDiscount;

    public int getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(int useTimes) {
        this.useTimes = useTimes;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Time getUseTimeLong() {
        return useTimeLong;
    }

    public void setUseTimeLong(Time useTimeLong) {
        this.useTimeLong = useTimeLong;
    }

    public int getUseTimesLocA() {
        return useTimesLocA;
    }

    public void setUseTimesLocA(int useTimesLocA) {
        this.useTimesLocA = useTimesLocA;
    }

    public int getUseTimesLocB() {
        return UseTimesLocB;
    }

    public void setUseTimesLocB(int useTimesLocB) {
        UseTimesLocB = useTimesLocB;
    }

    public int getUseTimesLocC() {
        return useTimesLocC;
    }

    public void setUseTimesLocC(int useTimesLocC) {
        this.useTimesLocC = useTimesLocC;
    }

    public int getUseTimesLocD() {
        return useTimesLocD;
    }

    public void setUseTimesLocD(int useTimesLocD) {
        this.useTimesLocD = useTimesLocD;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public double getUserDiscount() {
        return userDiscount;
    }

    public void setUserDiscount(double userDiscount) {
        this.userDiscount = userDiscount;
    }
}
