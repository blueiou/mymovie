package com.service;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dao.impl.SysUserDaoImpl;
import com.entity.Role;
import com.entity.User;
import com.model.OrdersInfo;
import com.model.PublicData;
import com.tools.CacheClass;
import com.tools.PulginsException;
public class SysUsersService {
	private SysUserDaoImpl sysUserDaoImpl;
	public SysUserDaoImpl getSysUserDaoImpl() {
		return sysUserDaoImpl;
	}
	public void setSysUserDaoImpl(SysUserDaoImpl sysUserDaoImpl) {
		this.sysUserDaoImpl = sysUserDaoImpl;
	}
	public List findByMid(String mid){
		if (CacheClass.isEmpty(mid)) return null;
		return sysUserDaoImpl.getContentById(mid);
		
	}
	public User findUserUnit(String na,String pa){
		if (CacheClass.isEmpty(na)||CacheClass.isEmpty(pa)) {
			new PulginsException("非法参数");
		}
		List<User> userlist=sysUserDaoImpl.uLogin(na, pa);//传入到数据处理层
		if (userlist.size()==0) {new PulginsException("没有该用户"); return null;}
		else {
			User user=userlist.get(0);
		/*Set<Role>	role=new HashSet<>();
		role=user.getRoles();
		Iterator iterator=role.iterator();// 获得一个迭代子
		Set<String> roleNameSet=new HashSet<>();//存放遍历出来名字
		while (iterator.hasNext()) {
			Role role2=(Role) iterator.next();
			//System.out.println(" "+role2.getRolename());
			roleNameSet.add(role2.getRolename());
		}
		if (roleNameSet.contains("generalUser")&&roleNameSet.contains("")) {
			return "user";
		}
		else if (roleNameSet.contains("")){}*/
			return user;
	}
		
}
	public PublicData findOrderInfo(String uid){
		PublicData publicData=null;
		
		if (!CacheClass.isEmpty(uid)) {
			publicData=new PublicData();
			List<OrdersInfo> list=sysUserDaoImpl.searchOrder(uid);
			if (list.size()>0) {
				publicData.setOrdersInfo(list);
				return publicData;
			}
		}
		else {
			new PulginsException("非法参数");return null;
		}
		return null;
	}
	public void delOrder(String uid,String oid){
		if (!CacheClass.isEmpty(uid)&&!CacheClass.isEmpty(oid)) {
			sysUserDaoImpl.del(uid, oid);
		}
		else {
			return;
		}
	}
}
