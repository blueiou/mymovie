package com.db;

public class DbParams {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/db_movie";
	private static String name="root";
	private static String password="123456";
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		DbParams.name = name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		DbParams.password = password;
	}
	public static String getDriver() {
		return driver;
	}
	public static String getUrl() {
		return url;
	}
	}
