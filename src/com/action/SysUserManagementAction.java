package com.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.entity.Role;
import com.entity.User;
import com.model.PublicData;
import com.service.SysGoodsService;
import com.service.SysUsersService;
import com.tools.CacheClass;
import com.tools.Functions;
public class SysUserManagementAction extends AjaxActionSupport{
	private SysUsersService sUser;
   private Object reply=null;
   private Map<String, Object> map;
   private  PublicData publicData;
	public SysUsersService getsUser() {
	return sUser;
}
public void setsUser(SysUsersService sUser) {
	this.sUser = sUser;
}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String mS=request.getParameter("m");
		int m=-1;
		if (CacheClass.isEmpty(mS)||!CacheClass.checkId(mS)) {
			m=1510;
		} else {
			 m=Integer.parseInt(mS);
		}
		System.out.println("sys管理m的值："+m);
		switch (m) {
		case Functions.USERINFO_OPERATION_ISSUE: //用户评价
			return userIssue();
		case Functions.USERINFO_OPERATION_LOGIN: //150 用户登录
			return getUser();
		case Functions.USERINFO_OPERATION_QUERY_ORDER://200查询订单
			return getOrders();
		default:
			break;
		}
		return ERROR;
	}
	public String  userIssue() {
		map=new HashMap<String, Object>();
		reply=sUser.findByMid(request.getParameter("mid"));
		map.put("reply", reply);
		return SUCCESS;
	}
	//查看用户个人订单
	public String getOrders(){
		HttpSession session=request.getSession();
		String uidString=(String) session.getAttribute("uid");
		if (!CacheClass.isEmpty(uidString)) {
			
			publicData=sUser.findOrderInfo(uidString);
			System.out.println("publicData:"+publicData);
			map.put("data", sUser.findOrderInfo(uidString));
			map.put("success", true);
			return SUCCESS;
		}
		return SUCCESS;
	}
	//用户登录
	public String getUser(){
		 HttpSession session=request.getSession();
			map=new HashMap<String, Object>();
			User user=sUser.findUserUnit(request.getParameter("uname"), request.getParameter("upass"));
			if (user==null) {
				map.put("user", null);
				map.put("success", false);
				return SUCCESS;
			}
			else if (user!=null) {
				session.setAttribute("uid", user.getUserid());
				session.setAttribute("uname", user.getUsername());
				session.setAttribute("urole", user.getRoles());
				//session.setAttribute("urole", value);
				map.put("user", user);
				map.put("success", true);
				return SUCCESS;
			}
			return SUCCESS;
	}
	public String  testU(){
		/*  HttpSession session=request.getSession();
		map=new HashMap<String, Object>();
		User user=sUser.findUserUnit(request.getParameter("uname"), request.getParameter("upass"));
		
		if (user==null) {
			map.put("user", null);
			map.put("success", false);
			return SUCCESS;
		}
		else if (user!=null) {
			session.setAttribute("uid", user.getUserid());
			session.setAttribute("uname", user.getUsername());
			session.setAttribute("urole", user.getRoles());
			//session.setAttribute("urole", value);
			map.put("user", user);
			map.put("success", true);
			return SUCCESS;
		}*/
		return SUCCESS;
		/*Set<Role>	role=new HashSet<>();
		Set<String> roleNameSet=new HashSet<>();//存放遍历出来名字
		role=user.getRoles();
		Iterator iterator=role.iterator();// 获得一个迭代子
		while (iterator.hasNext()) {
			Role role2=(Role) iterator.next();
			System.out.println(" role2.getRolename()"+role2.getRolename());
			roleNameSet.add(role2.getRolename());
		}
		if (roleNameSet.contains("generalUser")&&!roleNameSet.contains("manager")&&!roleNameSet.contains("administrator")) {
			System.out.println("user");
			return "user";
		}
		else if (roleNameSet.contains("manager")&&!roleNameSet.contains("administrator")){
			System.out.println("manager");
			return "manager";
		}
        else if (roleNameSet.contains("manager")&&roleNameSet.contains("administrator")){
			
			return "choose";
		}
        else if (roleNameSet.contains("administrator")){
        	System.out.println("administrator");
			return "administrator";
		}*/
		//return ERROR;
	/*	switch (key) {
		case value:
			
			break;

		default:
			break;
		}*/
	//	return SUCCESS;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
