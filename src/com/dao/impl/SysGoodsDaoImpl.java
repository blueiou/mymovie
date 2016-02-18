package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.SuperDao;
import com.dao.SysGoodsDao;
import com.entity.Goods;
import com.entity.Page;
import com.entity.Play;
import com.model.GoodVPlayVHall;
import com.model.GoodsInfo;
import com.tools.PulginsException;

public class SysGoodsDaoImpl  implements SysGoodsDao {
	private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	Play play=null;
	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Goods findList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page getPageList(int pageno ,int pagesize,final Class arg1,int stamp) {
		Page p = null;
		Criteria criteria=this.getHibernateTemplate().execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(arg1);
				return criteria;
			}
		}
		);
	/*	分页*/
	   int rowcount=getCount(stamp);
		criteria.setProjection(null);
		criteria.setFirstResult((pageno-1)*pagesize);
		criteria.setMaxResults(pagesize);
		criteria.add(Restrictions.eq("stamp", stamp));
		int pagecount = 0;
		if(rowcount%pagesize==0){
			pagecount=rowcount/pagesize;
		}
		else if(rowcount%pagesize!=0)
		{
			pagecount=rowcount/pagesize+1;
		}
		List<Goods> slist=criteria.list();
		 if (p==null) 
			 {
			 p=new Page(pagecount,pageno, pagesize, slist,rowcount);
			 }
		return p;
	}
	public  int getCount(int stamp){
		String hql = "select count(*) from Goods as Goods where stamp="+stamp;
		  Long count = (Long) getHibernateTemplate().find(hql).listIterator().next();
		  int ii = Integer.parseInt(String.valueOf(count)); 
		  return ii;
	}
	//根据商品ID查询单个商品详情
	public List getGoodById(String id) {
		Goods goods = null;
		if (goods==null) 	goods=new Goods();
		List<Goods> list= getHibernateTemplate().find("from Goods p where p.good_id=?",id);
		
		return list;
	}
	@Override
	 //查询某天放映的影片--关联了映射关系的查询
	public List getById(String temp) {
		// TODO Auto-generated method stub
		if (play==null) play=new Play();
		//List<Play> plays=getHibernateTemplate().find("from Play p where p.play_time like ?","%2016-02-14%");
		List<Play> plays=getHibernateTemplate().find("from Play p where p.play_time like ?",temp);
		return plays;
	}
	//查询单个商品的上映时间表 
	public List getByMId(String temp,String mid) {
		// TODO Auto-generated method stub
		//if (play==null) play=new Play();
		//List<Play> plays=getHibernateTemplate().find("from Play p where p.play_time like ?","%2016-02-14%");
		//List<Play> plays=getHibernateTemplate().find("select g.sysname,p.play_time,p.price,p.goods  from Play p,Goods g where g.good_id=? and p.play_time like ?",mid,temp);
		List<Play> plays=getHibernateTemplate().find("select p.play_time,p.price,g.sysname  from Play p,Goods g where g.good_id=? and p.play_time like ?",mid,temp);
		//List<Play> plays=getHibernateTemplate().find(" from Play p,Goods g where g.good_id=? ",mid);
		return plays;
	}
/*	public List getById() {
		// TODO Auto-generated method stub
		GoodVPlayVHall goodVPlayVHall=new GoodVPlayVHall();
		//List<Play> plays=getHibernateTemplate().find("from Play p where p.play_time like ?","%2016-02-14%");
		List<GoodVPlayVHall> plays=this.getHibernateTemplate().find("select goodVPlayVHall(g.sysname,h.roomname) from Play p,Goods g,Hall h  where p.good_id=g.good_id and p.hall_id=h.hall_id and  p.play_time like ?","%2016-02-17%");
		return plays;
	}*/
	@Override
	public List getById() {
		// TODO Auto-generated method stub
		return null;
	}
}
