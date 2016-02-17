package com.dao;

import java.util.List;

import com.entity.Goods;
import com.entity.Page;
import com.model.GoodsInfo;
import com.tools.PulginsException;

public interface SysGoodsDao {

	public Object findAll();
	public Goods findList();
	/*
	 *  @prama stamp 正在热映和预备上映 1：热映 0：预备上映
	 */
	Page getPageList(int pageno, int pagesize,Class arg1,int stamp);
	public List getGoodById(String  id) ;
	List getById(String temp);
	List getById();
}
