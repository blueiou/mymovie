package com.test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.SysTicketManageDao;
import com.dao.impl.SysGoodsDaoImpl;
import com.dao.impl.SysTicketDaoImpl;
import com.dao.impl.SysUserDaoImpl;
import com.entity.Play;
import com.entity.Role;
import com.entity.User;
import com.model.PlayByMid;
import com.service.SysTicketService;
//类中测试方法 已经注入到spring中的
public class TestApplication {
	public static void main(String args[]){
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	SysGoodsDaoImpl sysGoodsDaoImpl=(SysGoodsDaoImpl) act.getBean("SysGoodsDaoImpl");
	SysTicketDaoImpl sysTicketDaoImpl=(SysTicketDaoImpl) act.getBean("SysTicketDaoImpl");
	SysTicketService sysTicketService=(SysTicketService) act.getBean("SysTicketBo");
/*	SysUserDaoImpl sysUserDaoImpl=(SysUserDaoImpl) act.getBean("SysUserDaoImpl");
	
	Set<String> test1=new HashSet<>();
	test1.add("admin");
	test1.add("teacher");
	
	System.out.println(test1.contains("re"));
	}*/
	/*遍历显示hibernate返回的object[]*/
	 /*for (int i = 0; i < list.size(); i++) {
		 System.out.println(list[i]);
	}*/
	/*for (Object[] o : list) {
		System.out.println((String)o[0]);
		System.out.println(o[1]);
	}*/
	System.out.println(sysTicketDaoImpl.getSeats(1,"2016-02-24 09:55:00"));
	System.out.println(sysTicketService.findByTimeRoom("40288183530bcfba01530bcfbc360001"));
	
	}
	
	
	
}
