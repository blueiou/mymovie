package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DbConnect {
private Connection connection=null;
	public DbConnect(){
	
			try {
				Class.forName(DbParams.getDriver()).newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.print("数据库加载失败");
				e.printStackTrace();
			} 
	}
	 public boolean getConnection()  {
		      //  Connection	con=null;
				try {
				//	Class.forName(DbParams.getDriver()).newInstance();
					connection= (Connection) DriverManager.getConnection(DbParams.getUrl(), DbParams.getName(), DbParams.getPassword());
					connection.setAutoCommit(true);
				} 
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					 System.out.print("数据库链接失败");
					e.printStackTrace();
				}
			//return con;
			 //加载驱动,注册到驱动管理器
				
			return true;
			//创建Connection链接
		 }
	public Statement getStatement() throws Exception{
		if(connection==null) getConnection();
			Statement st= (Statement) connection.createStatement();//获取Statement
			return st;
			 
		 }
	public PreparedStatement getPreparedStatemen(String sql) throws Exception{
		if(connection==null) 
		{ getConnection();}
			PreparedStatement ps=(PreparedStatement)connection.prepareStatement(sql);
			return ps;
	}
	
	public boolean update(String sql){
		int i=-1;
		try {
			i = getPreparedStatemen(sql).executeUpdate();
			if (i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void closeconn(){
		try {
			if(getStatement()!= null)  getStatement().close(); 
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(ResultSet rs, Statement stmt,
			Connection con) {
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(con);
	}
		}
