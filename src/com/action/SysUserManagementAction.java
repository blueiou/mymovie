package com.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.entity.Role;
import com.entity.User;
import com.service.SysGoodsService;
import com.service.SysUsersService;
import com.tools.CacheClass;
import com.tools.Functions;
public class SysUserManagementAction extends AjaxActionSupport{
	private SysUsersService sUser;
   private Object reply=null;
   private Map<String, Object> map;
  // HttpSession session=request.getSession();
	public SysUsersService getsUser() {
	return sUser;
}
public void setsUser(SysUsersService sUser) {
	this.sUser = sUser;
}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
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
		System.out.println("enter"+m);
		switch (m) {
		case Functions.USERINFO_OPERATION_ISSUE: //用户评价
			System.out.println("enter");
			return userIssue();

		default:
			break;
		}
		return SUCCESS;
	}
	public String  userIssue() {
		map=new HashMap<String, Object>();
		reply=sUser.findByMid(request.getParameter("mid"));
		map.put("reply", reply);
		return SUCCESS;
	}
	public void testU(){
		map=new HashMap<String, Object>();
		User user=sUser.findUserUnit(request.getParameter("uname"), request.getParameter("pass"));
	Set	role=new HashSet<>();
	role=user.getRoles();
	Iterator iterator=role.iterator();// 获得一个迭代子
	while (iterator.hasNext()) {
		Role role2=(Role) iterator.next();
		System.out.println(" "+role2);
		
	}
	/*	switch (key) {
		case value:
			
			break;

		default:
			break;
		}*/
		
		
	//	return SUCCESS;
	}
}
