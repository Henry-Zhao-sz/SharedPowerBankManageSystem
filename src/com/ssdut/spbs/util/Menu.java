package com.ssdut.spbs.util;

import java.util.*;
import com.ssdut.spbs.entity.*;
import com.ssdut.spbs.service.Impl.*;
import com.ssdut.spbs.service.*;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    static int cursor = 0;
    static user user1 = null;
    static admin admin1 = null;

    // 程序主菜单
    public static void showSPBSMenu() {
        System.out.println("------------欢迎来到共享充电宝管理系统-------------");
        System.out.println("1：管理员登录   2：普通用户登录    3：用户注册");
        while (true) {
            try {
                cursor = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("请输入正确选择：1：管理员登录   2：普通用户登录    3：用户注册");
                sc = new Scanner(System.in);
            }
        }
        switch (cursor) {
            case 1:
                admin1 = showAdmincheckLogMenu();
                showAdminMenu();// 验证通过进入管理员菜单
                break;
            case 2:
                user1 = showcheckLogMenu();
                showUserMenu();// 验证通过进入普通用户菜单
                break;
            case 3:
                boolean i = RegMenu();
                if (i) {
                    System.out.println("注册成功");
                    showSPBSMenu();// 注册结束返回主菜单
                } else {
                    System.out.println("注册失败");// 注册失败返回主菜单
                    showSPBSMenu();
                }
                break;
            default:
                System.out.println("输入错误，请重新输入");
                showSPBSMenu();
                break;
        }
    }

    //管理员登录
    public static admin showAdmincheckLogMenu() {
        BaseService bsi = new BaseServiceImpl();
        admin admin1 = null;
        System.out.println("请输入账号名字");
        String adname = sc.next();
        System.out.println("请输入密码");
        String adpass = sc.next();
        while (true) {
            try {
                admin1 = bsi.checkAdminLogin(adname, adpass);
                if (admin1 == null) {
                    System.out.println("您输入的账号不存在");
                    showSPBSMenu();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return admin1;
        }
    }

    // 用户登录
    public static user showcheckLogMenu() {
        BaseService bsi = new BaseServiceImpl();
        user user1 = null;
        System.out.println("请输入账号名字");
        String uname = sc.next();
        System.out.println("请输入密码");
        String upass = sc.next();
        while (true) {
            try {
                user1 = bsi.checkLogin(uname, upass);
                if (user1 == null) {
                    System.out.println("您输入的账号不存在");
                    showSPBSMenu();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user1;
        }
    }

    // 用户注册
    public static boolean RegMenu() {
        BaseService bsi = new BaseServiceImpl();
        System.out.println("请输入账号ID");
        int uid = sc.nextInt();
        System.out.println("请输入账号名字");
        String uname = sc.next();
        System.out.println("请输入密码");
        String upass = sc.next();
        System.out.println("请输入手机号码");
        String uphone = sc.next();
        user user1 = new user();
        user1.setUserID(uid);
        user1.setUserName(uname);
        user1.setUserPwd(upass);
        user1.setUserPhone(uphone);
        boolean result = bsi.register(user1);
        return result;
    }


    // 管理员主菜单
    public static void showAdminMenu() {
        System.out.println("1.管理站点情况 2.管理用户情况 ......");
        while (true) {
            try {
                cursor = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("请重新输入正确选项：1.管理站点情况 2.管理用户情况 ......");
                sc = new Scanner(System.in);
            }
        }
        switch (cursor) {
            case 1:
                showlocManager();// 站点管理
                break;
            case 2:
                showuserManager();// 用户管理
                break;
            default:
                System.out.println("输入无效，提示输入值为1-2之间的整数，请重新输入");
                showAdminMenu();
                break;
        }

    }

    // 用户主菜单
    public static void showUserMenu() {
        System.out.println("1.查看站点情况 2.管理个人情况 ......");
    }


    public static void showlocManager(){
        LocService lsi = new LocServiceImpl();
        System.out.println("1.查询所有站点 2.查找指定站点 3.查找指定区域 4.增设站点 5.返回管理员菜单");
        while (true) {
            try {
                cursor = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("请重新输入正确选项：1.查询所有站点 2.查找指定站点 3.查找指定区域 4.增设站点 5.返回管理员菜单");
                sc = new Scanner(System.in);
            }
        }
        switch (cursor) {
            case 1:
                List<loc> list = lsi.showAllLoc();
                System.out.println("站点编号\t"+"站点信息\t\t\t"+"可用数量\t"+"总计数量\t"+"最大容量\t"+"借出次数");
                for (loc loc1:list) {
                    System.out.println(loc1.getLocID()+"\t    "+loc1.getLocInfo()+"\t  "+loc1.getAvailNum()+"\t\t"+loc1.getTotalNum()+"\t\t"+loc1.getMaxVolume()+"\t\t"+loc1.getLendTime());
                }
                showlocManager();
                break;

            case 2:
                System.out.println("请输入要查找的站点的站点编号：");
                sc = new Scanner(System.in);
                String lid=sc.next();
                loc loc1= lsi.showSpeLoc(lid);
                System.out.println("站点编号\t"+"站点信息\t\t\t"+"可用数量\t"+"总计数量\t"+"最大容量\t"+"借出次数");
                System.out.println(loc1.getLocID()+"\t   "+loc1.getLocInfo()+"\t  "+loc1.getAvailNum()+"\t\t"+loc1.getTotalNum()+"\t\t"+loc1.getMaxVolume()+"\t\t"+loc1.getLendTime());
                showlocManager();
                break;

            case 3:
                System.out.println("请输入要查找的区域(A/B/C/D)：");
                sc = new Scanner(System.in);
                String rid=sc.next();
                List<loc> list1= lsi.showSpeRegion(rid);
                System.out.println("站点编号\t"+"站点信息\t\t\t"+"可用数量\t"+"总计数量\t"+"最大容量\t"+"借出次数");
                for (loc loc2:list1) {
                    System.out.println(loc2.getLocID()+"\t   "+loc2.getLocInfo()+"\t  "+loc2.getAvailNum()+"\t\t"+loc2.getTotalNum()+"\t\t"+loc2.getMaxVolume()+"\t\t"+loc2.getLendTime());
                }
                showlocManager();
                break;

            case 4:
                boolean i = AddLocMenu();
                if (i) {
                    System.out.println("添加站点成功");
                    showlocManager();// 添加成功返回站点管理页面
                } else {
                    System.out.println("添加失败");// 添加失败返回站点管理页面
                    showlocManager();
                }
                break;


            case 5:
                showAdminMenu();
                break;
            default:
                System.out.println("输入无效，提示1/2/3/4");
                showlocManager();
                break;
        }
    }

   public static void showuserManager() {
        UserService usi = new UserServiceImpl();
        System.out.println("1.查询所有用户 2.查找指定用户 3.删除指定用户 4.返回管理员菜单");
        while (true) {
            try {
                cursor = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("请重新输入正确选项：1.查询所有用户 2.查找指定用户 3.删除指定用户 4.返回管理员菜单");
                sc = new Scanner(System.in);
            }
        }
        switch (cursor) {
            case 1:
                List<user> list = usi.showAllUser();
                System.out.println("用户编号\t"+"用户姓名\t"+"用户密码\t"+"用户电话\t\t"+"使用次数\t"+"使用时长\t"+"A区使用次数\t"+"B区使用次数\t"+"C区使用次数\t"+"D区使用次数\t"+"账户余额\t\t"+"折扣\t");
                for (user user1:list) {
                    System.out.println(user1.getUserID()+"\t"+user1.getUserName()+"\t"+user1.getUserPwd()+"\t"+user1.getUserPhone()+"\t   "+user1.getUseTimes()+"\t"+user1.getUseTimeLong()+"\t"+user1.getUseTimesLocA()+"\t\t"+user1.getUseTimesLocB()+"\t\t\t"+user1.getUseTimesLocC()+"\t\t\t"+user1.getUseTimesLocD()+"\t\t\t"+user1.getUserBalance()+"\t\t"+user1.getUserDiscount());
                }
                showuserManager();
                break;

            case 2:
                System.out.println("请输入要查找的用户的用户编号：");
                sc = new Scanner(System.in);
                int uid=sc.nextInt();
                user user1=usi.showSpeUser(uid);
                System.out.println("用户编号\t"+"用户姓名\t"+"用户密码\t"+"用户电话\t\t"+"使用次数\t"+"使用时长\t"+"A区使用次数\t"+"B区使用次数\t"+"C区使用次数\t"+"D区使用次数\t"+"账户余额\t\t"+"折扣\t");
                System.out.println(user1.getUserID()+"\t"+user1.getUserName()+"\t"+user1.getUserPwd()+"\t"+user1.getUserPhone()+"\t   "+user1.getUseTimes()+"\t"+user1.getUseTimeLong()+"\t"+user1.getUseTimesLocA()+"\t\t"+user1.getUseTimesLocB()+"\t\t\t"+user1.getUseTimesLocC()+"\t\t\t"+user1.getUseTimesLocD()+"\t\t\t"+user1.getUserBalance()+"\t\t"+user1.getUserDiscount());
                showuserManager();
                break;

            case 3:
                System.out.println("请输入要删除的用户的用户编号：");
                sc = new Scanner(System.in);
                int uid1=sc.nextInt();
                int flag = usi.removeSpeUser(uid1);
                if(flag!=0){
                    System.out.println("删除用户成功");
                    showuserManager();
                }
                else{
                    System.out.println("该用户不存在，删除失败");
                    showuserManager();
                }

            case 4:
                showAdminMenu();
                break;
            default:
                System.out.println("输入无效，提示1/2/3/4");
                showuserManager();
                break;
        }
    }

    // 用户注册
    public static boolean AddLocMenu() {
        LocService lsi = new LocServiceImpl();
        System.out.println("请输入站点ID");
        String lid = sc.next();
        System.out.println("请输入站点具体位置信息");
        String lInfo = sc.next();
        System.out.println("请输入该站点充电宝总数");
        int ltotalnum = sc.nextInt();
        System.out.println("请输入该站点充电宝最大容量");
        int lmaxVolume = sc.nextInt();
        loc loc1 = new loc();
        loc1.setLocID(lid);
        loc1.setLocInfo(lInfo);
        loc1.setAvailNum(ltotalnum);
        loc1.setTotalNum(ltotalnum);
        loc1.setMaxVolume(lmaxVolume);
        boolean result = lsi.addLoc(loc1);
        return result;
    }


}