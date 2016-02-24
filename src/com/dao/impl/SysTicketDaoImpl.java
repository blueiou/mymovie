package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Play;

public class SysTicketDaoImpl {
	private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
//查询预定的位置  根据房间号和时间
	public List getSeats(String room,String time){
		String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.roomname=? and tp.play_time=?";
		List plays=this.getHibernateTemplate().find(hqlString,room,time);
		return plays;
		
	}
	//根据 id和时间传递
	public List getSeats(int h_id,String time){
		//String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.roomname=? and tp.play_time=?";
		String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.hall_id=? and tp.play_time=?";
		List plays=this.getHibernateTemplate().find(hqlString,h_id,time);
		return plays;
		
	}
	public List<Object[]> getPlayId(String id){
		String roomtimehql="select p.hall.roomname,p.play_time from Play p where p.play_id=?";
		List list=this.getHibernateTemplate().find(roomtimehql,id);
		return list;
	}
	public void test(){
		/*
		String roomtimehql="select p.hall.roomname,p.play_time from Play p where p.play_id=?";
		List list=this.getHibernateTemplate().find(roomtimehql,"40288183530bcfba01530bcfbc360001");
		return list;*/
		
	}
	
}
