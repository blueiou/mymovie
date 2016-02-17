package com.service;

import java.util.List;

import com.dao.impl.SysUserDaoImpl;

public class SysUsersService {

	private SysUserDaoImpl sysUserDaoImpl;

	public SysUserDaoImpl getSysUserDaoImpl() {
		return sysUserDaoImpl;
	}

	public void setSysUserDaoImpl(SysUserDaoImpl sysUserDaoImpl) {
		this.sysUserDaoImpl = sysUserDaoImpl;
	}
	public List findByMid(String mid){
		
		return sysUserDaoImpl.getContentById(mid);
		
	}
}
