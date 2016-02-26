package com.dao.impl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.entity.Play;
import com.entity.Ticket;
import com.entity.User;
import com.tools.MyDate;
public class SysTicketDaoImpl {
	private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

MyDate date=new MyDate();
	/***************************查询SEARCH*/
//查询预定的位置  根据房间号和时间
	public List getSeats(String room,String time){
		String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.roomname=? and tp.play_time=?";
		List plays=this.getHibernateTemplate().find(hqlString,room,time);
		return plays;
	}
	//根据 id和时间传递,查找同一房间号同一时间段的座位号
	public List getSeats(int h_id,String time){
		String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.hall_id=? and tp.play_time=?";
		List plays=this.getHibernateTemplate().find(hqlString,h_id,time);
		return plays;
	}
	public List<Object[]> getPlayId(String id){
		String roomtimehql="select p.hall.roomname,p.play_time from Play p where p.play_id=?";
		List list=this.getHibernateTemplate().find(roomtimehql,id);
		return list;
	}
    /******************************UPDATE*/
	//添加用户购买的电影票
	public int add(String play_id,String u_id,String seat,double price){
		int count=0;
		this.getHibernateTemplate().save(getTicket(play_id, u_id, seat, price));
		count++;
		return count;
	}
	public Ticket getTicket(String play_id,String u_id,String seat,double price){
		Ticket ticket=new Ticket(date.getYMDHM()+MyDate.getRandomN());
		ticket.setCode(date.getYMDHMS()+MyDate.getRandomN());
		ticket.setCurrPrice(price);
		ticket.setU_seat(seat);
		Play play1=(Play) getForeignkey(Play.class,play_id);
		User u1=(User) getForeignkey(User.class,u_id);
		ticket.setPlay(play1);
		ticket.setUser(u1);
	//	this.getHibernateTemplate().saveOrUpdate(ticket);
		return ticket;
	}
	//获取缓存中的实体类的信息
	public Object getForeignkey(final Class arg,final String id){
		return this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				return session.get(arg,id);
			}
		});
		
	}
	
	
	
}
