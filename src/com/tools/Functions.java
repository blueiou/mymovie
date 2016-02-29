package com.tools;

public interface Functions {
	//**********************影院影片操作*********************************
public final int GOODS_OPERATION = 1500;   //商品操作
public final int GET_GOODS_OPERATION_LIST0=GOODS_OPERATION+ 10; //1510 获取商品列表      预备上映
public final int GET_GOODS_OPERATION_LIST1=GOODS_OPERATION+ 11; //1511 获取商品列表      正在上映



public final int GET_GOODS_OPERATION_INFO =GOODS_OPERATION+ 20;     //1520 取某商品详细信息	
public final int GET_GOODS_OPERATION_PlayTime_ById =GOODS_OPERATION+ 21;     //1521 获取某天放映的特定的电影时间列表	


public final int GET_GOODS_OPERATION_PlayTime=GOODS_OPERATION+25;  //1525 获取某天放映的电影列表



//**********************用户操作*********************************
public final int USERINFO_OPERATION = 100;   //用户基本信息
public final int USERINFO_OPERATION_LOGIN=USERINFO_OPERATION+50;    //150用户登录
public final int USERINFO_OPERATION_QUERY_ORDER=USERINFO_OPERATION+100; //200查询订单
public final int USERINFO_OPERATION_ISSUE=USERINFO_OPERATION+10086; //10186用户影片评价 
public final int USERINFO_OPERATION_INDEX=USERINFO_OPERATION-101;   //-1 返回首页
public final int USERINFO_OPERATION_DEL_ORDER=USERINFO_OPERATION+150; //250 删除订单


//*********************票务管理**********************************

public final int TICKET_OPERATION=1700;   //从选座位开始
public final int TICKET_OPERATION_SEARCH_SEAT=TICKET_OPERATION+10;// 1710查询可预订的位置
public final int TICKET_OPERATION_PRODUCED_ORDER=TICKET_OPERATION+25;//1725 生成订单






}
