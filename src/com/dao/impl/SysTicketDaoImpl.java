package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class SysTicketDaoImpl {
	private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
//查询预定的位置
	public List getSeats(String room,String time){
		String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.roomname=? and tp.play_time=?";
		List plays=this.getHibernateTemplate().find(hqlString,room,time);
		return plays;
		
	}
	
	
	
}
