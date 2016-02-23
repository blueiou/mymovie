package com.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Application;

import org.springframework.context.support.ClassPathXmlApplicationContext; 
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.SuperDao;
import com.dao.SysGoodsDao;
import com.entity.Goods;
import com.entity.Page;
import com.entity.Play;
import com.model.GoodVPlayVHall;
import com.model.GoodsInfo;
import com.model.PlayByMid;
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
	public List getByMId(String mid,String stemp) {
		// TODO Auto-generated method stub
		//List<PlayByMid> plays=getHibernateTemplate().find("select new com.model.PlayByMid(g.sysname,p.play_time,p.price)  from Play p,Goods g where g.good_id=? and p.play_time like ?",mid,temp);
		//把查询出来的存放在数据模型的PlayByMid 中
		String hqlString="select new com.model.PlayByMid(p.goods.sysname,p.play_time,p.price,p.hall.roomname,p.hall.version,p.goods.baseInfo.language,p.goods.good_id,p.play_id) from Play p where p.goods.good_id=? and p.play_time like ?";
		List<PlayByMid> plays=getHibernateTemplate().find(hqlString,mid,stemp);
		return plays;
	}
	public List test() {
		String hqlString="select t.u_seat from Ticket t  inner join  t.play tp inner join  tp.hall tph  where  tph.roomname=? and tp.play_time=?";
		List plays=this.getHibernateTemplate().find(hqlString,"2号厅","2016-02-23 09:55:00");
		return plays;
	}
	
	public List findByProperty(String propertyName, Object value,String temp) {
        try {
            String queryString = "from "+temp+" as model where model."
                    + propertyName + "= ?";
            Query queryObject = ((Session) this.getHibernateTemplate()).createQuery(queryString);
            queryObject.setParameter(0, value);
             
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
	@Override
	public List getById() {
		// TODO Auto-generated method stub
		return null;
	}
}
