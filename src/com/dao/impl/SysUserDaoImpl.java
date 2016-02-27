package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.springframework.orm.hibernate3.HibernateTemplate;

import com.db.DbConnect;
import com.entity.Role;
import com.entity.User;
import com.entity.UserInfo;
import com.model.OrdersInfo;
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
	
/*	public User login(String na, String pa) {
		   String f_name= "from User u where u.username=? and u.password=?"; 
	List<User> userlist=	hibernateTemplate.find(f_name, new String[]{na,pa});
	if (userlist.size()==0) 	return null;
	User users=userlist.get(0);
	String f_role="from  Role r where r.roleid in (select roleid from User_role where userid=?)";
	List<Role> rolelist=	hibernateTemplate.find(f_role, users.getUserid());
	Set<String> u1Roles = new HashSet<String>();
	for (int i = 0; i < rolelist.size(); i++) {
		Role roles=rolelist.get(i);
		u1Roles.add(roles.getRolename());
	}
	users.setRoles(u1Roles);
	return users;
	}*/
	public List uLogin(String na, String pa){
		  String f_name= "from User u where u.username=? and u.password=?";  
			List<User> userlist=this.hibernateTemplate.find(f_name, new String[]{na,pa});
		/*	if (userlist.size()==0) {System.out.println("没有查到到该用户");	return null;}
			else {User user=userlist.get(0);}*/
			return userlist;
		
	}

	
	public List<OrdersInfo> searchOrder(String uid){
		String hqlString="select new com.model.OrdersInfo(t.play.goods.sysname,t.play.play_time,t.statue) from Ticket t where t.user.userid=?";
		List<OrdersInfo> orderlList=this.hibernateTemplate.find(hqlString,uid);
		return orderlList;
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 dbConnect.closeconn();
		return list1;
	}
	
	
}
