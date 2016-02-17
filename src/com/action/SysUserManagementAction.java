package com.action;

import java.util.HashMap;
import java.util.Map;

import com.service.SysGoodsService;
import com.service.SysUsersService;

public class SysUserManagementAction extends AjaxActionSupport{

	
	private SysUsersService sUser;
   private Object reply=null;
   private Map<String, Object> map;

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
		map=new HashMap<String, Object>();
	//sUser.g
		reply=sUser.findByMid(request.getParameter("id"));
		map.put("reply", reply);
		return SUCCESS;
	}
	
	
	
	
}
