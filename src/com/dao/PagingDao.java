package com.dao;

import com.entity.Page;

public interface PagingDao {

	public Page getPageList();
/*
 *  @prama stamp 正在热映和预备上映
 */
	Page getPageList(int pageno, int pagesize,Class arg1,int stamp);
}
