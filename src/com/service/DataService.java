package com.service;

import java.util.List;

import com.dao.DataDao;
import com.entity.Data;
import com.tools.CheckId;
import com.tools.Md5;

public class DataService {
	DataDao dataDao=new DataDao();
	
	
	
	//�������  
	public List<Data> getDatasList(String params){
		return dataDao.datasList(params);
		
		
	}
	//ָ������SpecifySearch
	public List<Data> getSpecifySearchList(String params,String schar) {
		int xhnum=1;
		if (CheckId.checkPage(schar)) 
			{
			xhnum= Integer.parseInt(schar);
			
			}
		//��schar ת��Ϊ��ֵ��
		 return	dataDao.specifySearchList(params, xhnum);
		 
		}
	//��������
	
	public char[][] getRegroupList(String srcString){
		
		return dataDao.regroupList(srcString);
		
	}
	//ɾ��
	public boolean getDel(String dataid) {
		return dataDao.delete(dataid);
		
	}
	//�޸�
	public boolean getUpdat(String str,String dataid){
		return dataDao.updat(str, dataid);
	}
	//��½
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
	
	//���
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
