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
import com.entity.UserInfo;
import com.model.OrdersInfo;
import com.model.PlayByMid;
import com.service.SysTicketService;
//类中测试方法 已经注入到spring中的
public class TestApplication {
	public static void main(String args[]){
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	SysGoodsDaoImpl sysGoodsDaoImpl=(SysGoodsDaoImpl) act.getBean("SysGoodsDaoImpl");
	SysTicketDaoImpl sysTicketDaoImpl=(SysTicketDaoImpl) act.getBean("SysTicketDaoImpl");
	SysTicketService sysTicketService=(SysTicketService) act.getBean("SysTicketBo");
	SysUserDaoImpl sysUserDaoImpl=(SysUserDaoImpl) act.getBean("SysUserDaoImpl");
	/*
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
Play play1=(Play)sysTicketDaoImpl.getForeignkey(Play.class, "40288183530bccce01530bcccff80001");
/*List<OrdersInfo> list=sysUserDaoImpl.searchOrder();
	for (OrdersInfo info : list) {
		System.out.println(info.getStatue());
	}
	System.out.println();*/
	}
	
	
	
}
