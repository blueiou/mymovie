package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.dao.DataPageDaoT;
import com.dao.SuperDao;
import com.entity.Page;
import com.entity.Student;
import com.entity.Tb_datas;

public class DataPageDaoTImlp  implements DataPageDaoT{
	private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Page getpagelist(int pageno ,int pagesize){
		Page p = null;
		//Criteria criteria=getSession().createCriteria(Tb_datas.class);
		
		Criteria criteria=this.getHibernateTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(Tb_datas.class);
				return criteria;
			}
			
		}
		);
		int rowcount=(Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);
		criteria.setFirstResult((pageno-1)*pagesize);
		criteria.setMaxResults(pagesize);
		int pagecount = 0;
		if(rowcount%pagesize==0){
			pagecount=rowcount/pagesize;
		}
		else if(rowcount%pagesize!=0)
		{
			pagecount=rowcount/pagesize+1;
		}
		List<Tb_datas> slist=criteria.list();
		//分页导航二
		String sb2=getPageNum(pagecount,pageno,pagesize);
		 if (p==null) 
			 
			 {
			 p=new Page(pagecount,pageno, pagesize, slist,rowcount,sb2);
			 }
		return p;
		
		
		}
	public String getPageNum(int pagecount,int pageno,int pagesize){
		StringBuffer bar=new StringBuffer();  
	//如果是第一页  
		//添加分页导航
		bar.append("<nav><ul class='pagination'>");
		
	if(pageno == 1){  
	    bar.append("<li class='disabled'><span class='disabled'>Prev</span></li>")  
	       .append("<li class='active'><a href='testssh.action?pageno="+1+"'>" +1+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
	}else{  
	    bar.append("<li ><a href='testssh.action?pageno="+(pageno-1)+"'>Prev</a></li>")  
	       .append("<li ><a href='testssh.action?pageno=1'>1</a></li>");  
	}  
	//** 
	// * 结束(第一页) 
	 //*  
	  
	//如果总页数小于11  
	if(pagecount <= 11){  
	    for(int i =2 ; i<pagecount;i++){  
	        if(pageno==i){  
	            bar.append("<li class='active'><a href='testssh.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
	        }else{  
	            bar.append("<li><a href='testssh.action?pageno="+i+"'>"+i+"</a></li>");  
	        }  
	    }  
	}else{//总页数大于11  
	    if(pageno <=6){                         //当前页小页等于6时  (页码要与前面的街上)  
	        for(int i=2;i<=7;i++){  
	            if(pageno==i){  
	                bar.append("<li class='active'><a href='testssh.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></li>");  
	            }else{  
	                bar.append("<li><a href='testssh.action?pageno="+i+"'>"+i+"</a></li>");  
	            }  
	        }  
	        bar.append("<li><span>....</span></li>");  
	        bar.append("<li><a href='testssh.action?pageno="+(pagecount-1)+"'>"+(pagecount-1)+"</a></li>");  
	    }else if(pageno>=pagecount-5){              //当前页大于最大页-5时 要与后面的接上  
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
	  
	  
	//如果是最后一页  
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
	
	public void saveStu(Student stu){
		getHibernateTemplate().save(stu);
	}
/*public static void main(String args[]){
	
	
	
}*/
}
