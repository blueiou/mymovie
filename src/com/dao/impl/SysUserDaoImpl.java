package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.db.DbConnect;
import com.entity.UserInfo;
import com.model.SysGoodsData;
import com.mysql.jdbc.PreparedStatement;
import com.service.SysGoodsService;
import com.tools.CacheClass;

public class SysUserDaoImpl {
private DbConnect dbConnect;
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//查找用户对某影片的评论
	public List getContentById(String mid){
		//UserInfo userInfo=new UserInfo();
		List<SysGoodsData> list1=new ArrayList<>();
		 dbConnect=new DbConnect();
		  PreparedStatement psPreparedStatement=null;
		try {
			//psPreparedStatement = dbConnect.getPreparedStatemen("select distinct  content from uservgood where good_id=?");
			psPreparedStatement = dbConnect.getPreparedStatemen("select distinct  u.username,ug.content from uservgood ug,users u where ug.userid=u.userid and  good_id=?");
			psPreparedStatement.setString(1, mid);
			   ResultSet rsResultSet=psPreparedStatement.executeQuery();
			   while (rsResultSet.next()) {
				    SysGoodsData sysGoodsData=new SysGoodsData();
				    sysGoodsData.setName(rsResultSet.getString(1));
				    sysGoodsData.setMsg(rsResultSet.getString(2));
				    list1.add(sysGoodsData);
				   System.out.println("sysGoodsData="+sysGoodsData.getMsg());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 dbConnect.closeconn();
		return list1;
	}
	
	
}
