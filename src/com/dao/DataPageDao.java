package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;

import com.entity.Page;
import com.entity.Tb_datas;


public class DataPageDao  {
	//获取工厂
	Session sessions=null;
	SessionFactory factory=null;
	public  boolean getHSession() {
		
		factory=new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		sessions =factory.openSession();
		return true;
	}
//	
//	@SuppressWarnings("unused")
	public Page getpagelist(int pageno ,int pagesize){
		Page p = null;
		
		if (sessions==null) getHSession();
		Criteria criteria=sessions.createCriteria(Tb_datas.class);
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
	//	System.out.print(slist);
		//String sbB=getPageNumNew(pagecount, pageno, pagesize);
		//分页导航二
		String sb2=getPageNum(pagecount,pageno,pagesize);
		 if (p==null) 
			 
			 {
			 p=new Page(pagecount,pageno, pagesize, slist,rowcount,sb2);
			 }
		closeSession(sessions);
		return p;
	}
	/*
	 * 
	 * 分页2导航
	 * 
	 */
	public String getPageNum(int pagecount,int pageno,int pagesize){
	StringBuffer bar=new StringBuffer();  
//如果是第一页  
	//添加分页导航
	bar.append("<nav><ul class='pagination'>");
	
if(pageno == 1){  
    bar.append("<li class='disabled'><span class='disabled'>Prev</span></li>")  
       .append("<li class='active'><a href='datapage.action?pageno="+1+"'>" +1+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
}else{  
    bar.append("<li ><a href='datapage.action?pageno="+(pageno-1)+"'>Prev</a></li>")  
       .append("<li ><a href='datapage.action?pageno=1'>1</a></li>");  
}  
//** 
// * 结束(第一页) 
 //*  
  
//如果总页数小于11  
if(pagecount <= 11){  
    for(int i =2 ; i<pagecount;i++){  
        if(pageno==i){  
            bar.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
        }else{  
            bar.append("<li><a href='datapage.action?pageno="+i+"'>"+i+"</a></li>");  
        }  
    }  
}else{//总页数大于11  
    if(pageno <=6){                         //当前页小页等于6时  (页码要与前面的街上)  
        for(int i=2;i<=7;i++){  
            if(pageno==i){  
                bar.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></li>");  
            }else{  
                bar.append("<li><a href='datapage.action?pageno="+i+"'>"+i+"</a></li>");  
            }  
        }  
        bar.append("<li><span>....</span></li>");  
        bar.append("<li><a href='datapage.action?pageno="+(pagecount-1)+"'>"+(pagecount-1)+"</a></li>");  
    }else if(pageno>=pagecount-5){              //当前页大于最大页-5时 要与后面的接上  
        bar.append("<li><a href='datapage.action?pageno=2'>"+2+"</a></li>");  
        bar.append("<li><span>....</span></li>");  
        for(int i=pagecount-5-3;i<=pagecount-1;i++){  
            if(pageno==i){  
                bar.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></li>");  
            }else{  
                bar.append("<li><a href='datapage.action?pageno="+i+"'>"+i+"</a></li>");  
            }  
        }  
    }else{  
        bar.append("<li><a href='datapage.action?pageno=2'>"+2+"</a></li>");  
        bar.append("<li><span>....</span></li>");  
        for(int i=pageno-3;i<=pageno+3;i++){  
            if(pageno==i){  
                bar.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
            }else{  
                bar.append("<li><a href='datapage.action?pageno="+i+"'>"+i+"</a></li>");  
            }  
        }  
        bar.append("<li><span>....</span></li>");  
        bar.append("<li><a href='datapage.action?pageno="+(pagecount-1)+"'>"+(pagecount-1)+"</a></li>");  
    }  
}  
  
  
//<li class='disabled'><span class='disabled'>Prev</span></li>
//如果是最后一页  
if(pageno == pagecount){  
  bar.append("<li class='active'><a href='datapage.action?pageno="+pagecount+"'>" +pagecount+ "<span class='sr-only'>"+pageno+"</span></a></li>")
//	bar.append("<li class='disabled'><a href='datapage.action?pageno="+pagecount+"'>" +pagecount+ "<span class='disabled'>Prev</span></a></li>")
       .append("<li class='disabled'><span class='disabled'>Next</span></li>");  
}else{  
    bar.append("<li><a href='datapage.action?pageno="+pagecount+"'>"+pagecount+"</a></li>")  
       .append("<li><a href='datapage.action?pageno="+(pageno+1)+"'>Next</a></li>");  
}
//跳转页数
/*bar.append("<select style='height:33px;text-align: center;padding: 0.3em 0.5em;' onchange=\"location.href='datapage.action?pageno=this.value'\">");  
for(int i=1;i<=pagecount;i++){  
    if(pageno==i){  
        bar.append("<option value='"+i+"' selected='selected'>").append("第"+i+"页").append("</option>");  
    }else{  
        bar.append("<option value='"+i+"'>").append("第"+i+"页").append("</option>");  
    }  
}  
bar.append("</select>"); */
bar.append("</ul></nav>");
return bar.toString();  
		
		
	}
/*
 * 分页1 页码无省略
 * 	
 */
	public String getPageNumNew(int pagecount,int pageno,int pagesize){	
		StringBuffer sb=new StringBuffer();
		sb.append("<nav><ul class='pagination'>");
		
		for(int i=1;i<=pagecount;i++){
				if(i==pageno){
					if (pageno==1) {
						sb.append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
					}
					sb.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");
					//sb.append("["+i+"]");
				}else{
					//鏋勫缓鍒嗛〉瀵艰埅
					sb.append("<li ><a href='datapage.action?pageno="+i+"'>" +i+ "</a></li>");			
				}
				if (i==pagecount) {
					sb.append("</ul></nav>");
				}sb.append("");	
					
		/*StringBuffer sb=new StringBuffer();
		sb.append("<nav><ul class='pagination'>");
		if (pageno==1) {
			sb.append("<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		}
		for(int i=1;i<=pagecount;i++){
				if(i==pageno){
					sb.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");
					//sb.append("["+i+"]");
				}else{
					//鏋勫缓鍒嗛〉瀵艰埅
					sb.append("<li ><a href='datapage.action?pageno="+i+"'>" +i+ "</a></li>");			
				}
				if (i==pagecount) {
					sb.append("</ul></nav>");
				}sb.append("");	
				
			}*/
		}
		return sb.toString();		
	}
 public  void closeSession(Session session) {
	        if (session != null||factory!=null) {
	            if (session.isOpen()) {
	                session.close(); // 关闭Session
	            }
	            factory.close();
	        }
	     //   HibernateSessionFactory.closeSession();
	    }
//	public static void main(String[] args) throws SQLException, Exception {
//		DataPageDao dao=new DataPageDao();
//		Page page=new Page();
//		page=dao.getpagelist(1, 3);
//		
//		System.out.print(page.getRowcount());
//	}
}
