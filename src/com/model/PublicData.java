package com.model;

import java.util.ArrayList;
import java.util.List;

import com.tools.CacheClass;



public class PublicData extends BaseData{

	public String code;	
	public String value;

    public String name;//呢称
    public String sex;//性别，0为女性
	public String avatar;//头像
 
    public String real_name1;
    public String real_address1;
    public String real_tel1;
    public String real_name2;
    public String real_address2;
    public String real_tel2;
    public String address;
    public String userid;
	public String jid;
	public String nickname;
	public String Online;
	public String age;
	public String result;
	public String totalman;
	
	public String selfrmbrank;
	public String selfmanrank;
	public String selflevelrank;
	
	public String rmb;
	public String rmb1;
	public String rmb2;
	public String rmb3;
	public String rmb98;
	public String rmb99;
	
	//聊天
	public String chat_type;
	public String chat_content_txt;
	public String chat_content_pic;
	public String chat_content_voice;
	public String chat_time;
	public String curPage;
	public String curpage;
	public String total;
	public String start;
	public String limit;
	public String duration;
	public String dist;
	
	public String longitude1;
	public String latitude1;
	public String shop_lon;
	public String shop_lat;
	public String gps_1_updateNum;
	public String gps_2_updateNum;
	
	public String updatetime;
	public String verson;
	public String downloadurl;
	public String url;
	public String imgurl;

	public String activite;
	public String lon;
	public String lat;	
	
	public String content_txt;

	public String neednum;
	public String havenum;
	public String type;
	public String msg;
	
	public List<Object> list= new ArrayList<Object>();
	public List<Object> list2= new ArrayList<Object>();
	public Object obj;

	public Object goods;
	public Object shop;
	public String purview_Note;
	public String params;
    public String areaname;			//片区名
	
	public PublicData()
	{
		list=null;
		list2=null;
		chat_time = CacheClass.getTime() + "";
	}


}
