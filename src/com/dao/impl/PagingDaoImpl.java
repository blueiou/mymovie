package com.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Expression;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.PagingDao;
import com.entity.Goods;
import com.entity.Page;
import com.entity.Tb_datas;

public class PagingDaoImpl implements PagingDao{
	private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override

	public Page getPageList(int pageno ,int pagesize,final Class arg1,int stamp) {
		Page p = null;
		//Criteria criteria=getSession().createCriteria(Tb_datas.class);
		
		Criteria criteria=this.getHibernateTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				//Criteria criteria=session.createCriteria(Tb_datas.class);
				//Class
				Criteria criteria=session.createCriteria(arg1);
				//criteria.add(criteria.eq)
				return criteria;
			}
			
		}
		);
		
	/*	分页*/
	   //int rowcount=(Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
	   int rowcount=getCount(stamp);
	   System.out.print("rowcount:"+rowcount);
	   //int rowcount=row.intValue();
		criteria.setProjection(null);
		criteria.setFirstResult((pageno-1)*pagesize);
		criteria.setMaxResults(pagesize);
		criteria.add(Restrictions.eq("stamp", stamp));
		//分组
		//System.out.print("getCount"+getCount());
		/*int rowcount=5;
		ProjectionList pList=Projections.projectionList();
		pList.add(Projections.rowCount());
		pList.add(Projections.groupProperty("stamp"));
		criteria.setProjection(pList);
		List<Object[]> goods = criteria.list();
	
			System.out.println("goods.get(1)[0]"+goods.get(1)[0]);
			
		switch (stamp) {
		case 0:
			rowcount=(Integer) goods.get(0)[0];
			System.out.println("rowcount:"+rowcount);
			break;
case 1:rowcount=(Integer) goods.get(1)[1];
			break;
		default:
			break;
		}
		criteria.setFirstResult((pageno-1)*pagesize);
		criteria.setMaxResults(pagesize);
		criteria.add(Restrictions.eq("stamp", stamp));*/
		int pagecount = 0;
		if(rowcount%pagesize==0){
			pagecount=rowcount/pagesize;
		}
		else if(rowcount%pagesize!=0)
		{
			pagecount=rowcount/pagesize+1;
		}
		List<Goods> slist=criteria.list();
		//��ҳ������
		//String sb2=getPageNum(pagecount,pageno,pagesize);
		 if (p==null) 
			 {
			//从后台传分页的样式
			 //p=new Page(pagecount,pageno, pagesize, slist,rowcount,sb2);
			 p=new Page(pagecount,pageno, pagesize, slist,rowcount);
			 }
		return p;
	}
	public  int getCount(int stamp){
	
		String hql = "select count(*) from Goods as Goods where stamp="+stamp;
		 //System.out.print("enter");
		  Long count = (Long) getHibernateTemplate().find(hql).listIterator().next();
		  int ii = Integer.parseInt(String.valueOf(count)); 
		  //System.out.print(count.intValue());
		  return ii;
	}
	//分页样式
	public String getPageNum(int pagecount,int pageno,int pagesize){
		StringBuffer bar=new StringBuffer();  
	//����ǵ�һҳ  
		//��ӷ�ҳ����
		bar.append("<nav><ul class='pagination'>");
		
	if(pageno == 1){  
	    bar.append("<li class='disabled'><span class='disabled'>Prev</span></li>")  
	       .append("<li class='active'><a href='testssh.action?pageno="+1+"'>" +1+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
	}else{  
	    bar.append("<li ><a href='testssh.action?pageno="+(pageno-1)+"'>Prev</a></li>")  
	       .append("<li ><a href='testssh.action?pageno=1'>1</a></li>");  
	}  
	//** 
	// * ����(��һҳ) 
	 //*  
	  
	//�����ҳ��С��11  
	if(pagecount <= 11){  
	    for(int i =2 ; i<pagecount;i++){  
	        if(pageno==i){  
	            bar.append("<li class='active'><a href='testssh.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
	        }else{  
	            bar.append("<li><a href='testssh.action?pageno="+i+"'>"+i+"</a></li>");  
	        }  
	    }  
	}else{//��ҳ�����11  
	    if(pageno <=6){                         //��ǰҳСҳ����6ʱ  (ҳ��Ҫ��ǰ��Ľ���)  
	        for(int i=2;i<=7;i++){  
	            if(pageno==i){  
	                bar.append("<li class='active'><a href='testssh.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></li>");  
	            }else{  
	                bar.append("<li><a href='testssh.action?pageno="+i+"'>"+i+"</a></li>");  
	            }  
	        }  
	        bar.append("<li><span>....</span></li>");  
	        bar.append("<li><a href='testssh.action?pageno="+(pagecount-1)+"'>"+(pagecount-1)+"</a></li>");  
	    }else if(pageno>=pagecount-5){              //��ǰҳ�������ҳ-5ʱ Ҫ�����Ľ���  
	        bar.append("<li><a href='testssh.action?pageno=2'>"+2+"</a></li>");  
	        bar.append("<li><span>....</span></li>");  
	        for(int i=pagecount-5-3;i<=pagecount-1;i++){  
	            if(pageno==i){  
	                bar.append("<li class='active'><a href='testssh.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></li>");  
	            }else{  
	                bar.append("<li><a href='testssh.action?pageno="+i+"'>"+i+"</a></li>");  
	            }  
	        }  
	    }else{  
	        bar.append("<li><a href='testssh.action?pageno=2'>"+2+"</a></li>");  
	        bar.append("<li><span>....</span></li>");  
	        for(int i=pageno-3;i<=pageno+3;i++){  
	            if(pageno==i){  
	                bar.append("<li class='active'><a href='testssh.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
	            }else{  
	                bar.append("<li><a href='testssh.action?pageno="+i+"'>"+i+"</a></li>");  
	            }  
	        }  
	        bar.append("<li><span>....</span></li>");  
	        bar.append("<li><a href='testssh.action?pageno="+(pagecount-1)+"'>"+(pagecount-1)+"</a></li>");  
	    }  
	}  
	  
	  
	//��������һҳ  
	if(pageno == pagecount){  
	  bar.append("<li class='active'><a href='testssh.action?pageno="+pagecount+"'>" +pagecount+ "<span class='sr-only'>"+pageno+"</span></a></li>")
	       .append("<li class='disabled'><span class='disabled'>Next</span></li>");  
	}else{  
	    bar.append("<li><a href='testssh.action?pageno="+pagecount+"'>"+pagecount+"</a></li>")  
	       .append("<li><a href='testssh.action?pageno="+(pageno+1)+"'>Next</a></li>");  
	}
	bar.append("</ul></nav>");
	return bar.toString();  
		}
	@Override
	public Page getPageList() {
		// TODO Auto-generated method stub
		return null;
	}
}
