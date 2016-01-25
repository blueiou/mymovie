package com.dao;

import com.entity.Page;

public interface PagingDao {

	public Page getPageList();

	Page getPageList(int pageno, int pagesize,Class arg1);
}
