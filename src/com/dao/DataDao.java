package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import com.db.DbConnect;
import com.entity.Data;
import com.entity.Users;
import com.mysql.jdbc.PreparedStatement;
import com.tools.CheckId;

public class DataDao {
	DbConnect dbConnect=null;
	public DataDao() {
		if (dbConnect==null) dbConnect=new DbConnect();
		
	}
	
	
	public List<Data> datasList(String params) {
		List<Data> list=new ArrayList();
		//String pString=params.trim()
		String sqlString="select * from tb_datas where data like '%"+params+"%'";
		ResultSet rsResultSet=null;
		try {
			PreparedStatement ps = dbConnect.getPreparedStatemen(sqlString);
	        rsResultSet=ps.executeQuery();
				while (rsResultSet.next()) {
					//限制长度
					String datasString=rsResultSet.getString("data");
					if (datasString.length()>=60) {
						datasString=datasString.substring(0, 60);
					}
					
					String idString=""+rsResultSet.getInt("id");
					Data datas=new Data(idString,datasString);
					list.add(datas);
				}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		finally{
			try {
				dbConnect.closeconn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
}
	//指定搜索  SpecifySearch
	public List<Data> specifySearchList(String params,int schar){
		List<Data> Specifylist=new ArrayList();
		String underscode="";
		//String pString=params.trim()
		if (schar>0&&schar<=19) {
			for (int i = 0; i < schar; i++) {
				underscode+="___";
			}
			try {
				String sqlString="select * from tb_datas where data like '"+underscode+""+params+"%'";
				ResultSet rsResultSet=null;
				PreparedStatement ps = dbConnect.getPreparedStatemen(sqlString);
		        rsResultSet=ps.executeQuery();
					while (rsResultSet.next()) {
						Data datas=new Data();
						//限制长度
						String datasString=rsResultSet.getString("data");
						if (datasString.length()>=60) {
							datasString=datasString.substring(0, 60);
						}
						String idString=""+rsResultSet.getInt("id");
						Data datas1=new Data(idString,datasString);
						Specifylist.add(datas1);
					}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			finally{
				try {
					dbConnect.closeconn();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return Specifylist;
}	
//重新排列
	public char[][] regroupList(String srcString) {
		char [] temp=srcString.toCharArray();	
		char[][] newchar = new char[10][6];
		char[][] newchar2 = new char[6][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				if ((i * 6 + j) >= temp.length) {
					break;
				} else {
					newchar[i][j] = temp[i * 6 + j];
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
			}
		}
		for (int i = 0; i < newchar.length; i++) {
			for (int j = 0; j < newchar[i].length; j++) {
				newchar2[j][i] = newchar[i][j]; // 转置核心
			}
		}
		
		return newchar2;
	}
	//delete data  删除数据
	public boolean delete(String dataid) {
		if (CheckId.checkId(dataid)) {
			if (dataid.length()>5) {
				return false;
			}
			String sql="delete from tb_datas where id="+dataid;
			if (dbConnect.update(sql)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean updat(String str,String dataid){
		//CheckId check=new CheckId();
		if (CheckId.checkData(str)) {
			if (str.length()>66) {
				return false;
			}
			String up_sql="update tb_datas set data='"+str+"' where id="+dataid;
			if (dbConnect.update(up_sql)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 用户登陆
	 */
	public boolean uLogin(String na,String pa){
		//Users users=null;
		String sql1="select * from tb_users where uName='"+na+"'";
		try {
			ResultSet rs= dbConnect.getPreparedStatemen(sql1).executeQuery();
			if(rs.next()){	
				String pwd=rs.getString("uPwd");

				if(pwd.equals(pa)){
			  //  if(users==null) users=new Users(rs.getInt("uId"));
			    return true;
				}		
				else return false;	
		}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				dbConnect.closeconn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			return false;	
			}
	
public boolean addData(String dataString) {
	//String sql1="select data from tb_datas where data='"+dataString+"'";
	String sql1="insert into tb_datas(data) values('"+dataString+"')";
	if (dbConnect.update(sql1)) {
		return true;
	}
	return false;
}	
	
	
	
}
