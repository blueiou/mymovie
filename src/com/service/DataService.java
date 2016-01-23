package com.service;

import java.util.List;

import com.dao.DataDao;
import com.entity.Data;
import com.tools.CheckId;
import com.tools.Md5;

public class DataService {
	DataDao dataDao=new DataDao();
	
	
	
	//随机搜索  
	public List<Data> getDatasList(String params){
		return dataDao.datasList(params);
		
		
	}
	//指定搜索SpecifySearch
	public List<Data> getSpecifySearchList(String params,String schar) {
		int xhnum=1;
		if (CheckId.checkPage(schar)) 
			{
			xhnum= Integer.parseInt(schar);
			
			}
		//将schar 转化为数值型
		 return	dataDao.specifySearchList(params, xhnum);
		 
		}
	//重新排列
	
	public char[][] getRegroupList(String srcString){
		
		return dataDao.regroupList(srcString);
		
	}
	//删除
	public boolean getDel(String dataid) {
		return dataDao.delete(dataid);
		
	}
	//修改
	public boolean getUpdat(String str,String dataid){
		return dataDao.updat(str, dataid);
	}
	//登陆
	public boolean getULogin(String na,String pa){
		if (na!=null&&pa!=null) {
		if (CheckId.checkUN(na)) {
			String nameString=Md5.getMD5(na);
			String passString=Md5.getMD5(pa);
				return dataDao.uLogin(nameString, passString);
			}
		}
		return false;
	}
	
	//添加
	public boolean getAddData(String str) {
		if (str!=null) {
			if (CheckId.checkData(str)) {
				if (str.length()>66) {
					return false;
				}
				return dataDao.addData(str);
			}
		}
		return false;
	}
}
