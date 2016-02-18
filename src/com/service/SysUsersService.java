package com.service;
import java.util.List;
import com.dao.impl.SysUserDaoImpl;
import com.tools.CacheClass;
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
}
