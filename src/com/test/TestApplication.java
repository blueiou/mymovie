package com.test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.impl.SysGoodsDaoImpl;
import com.dao.impl.SysUserDaoImpl;
import com.entity.Play;
import com.entity.Role;
import com.entity.User;
import com.model.PlayByMid;
//类中测试方法 已经注入到spring中的
public class TestApplication {
	public static void main(String args[]){
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	SysGoodsDaoImpl sysGoodsDaoImpl=(SysGoodsDaoImpl) act.getBean("SysGoodsDaoImpl");
	SysUserDaoImpl sysUserDaoImpl=(SysUserDaoImpl) act.getBean("SysUserDaoImpl");
	
	Set<String> test1=new HashSet<>();
	test1.add("admin");
	test1.add("teacher");
	
	System.out.println(test1.contains("re"));
	}
}