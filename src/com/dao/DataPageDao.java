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
	//��ȡ����
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
		//��ҳ������
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
	 * ��ҳ2����
	 * 
	 */
	public String getPageNum(int pagecount,int pageno,int pagesize){
	StringBuffer bar=new StringBuffer();  
//����ǵ�һҳ  
	//��ӷ�ҳ����
	bar.append("<nav><ul class='pagination'>");
	
if(pageno == 1){  
    bar.append("<li class='disabled'><span class='disabled'>Prev</span></li>")  
       .append("<li class='active'><a href='datapage.action?pageno="+1+"'>" +1+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
}else{  
    bar.append("<li ><a href='datapage.action?pageno="+(pageno-1)+"'>Prev</a></li>")  
       .append("<li ><a href='datapage.action?pageno=1'>1</a></li>");  
}  
//** 
// * ����(��һҳ) 
 //*  
  
//�����ҳ��С��11  
if(pagecount <= 11){  
    for(int i =2 ; i<pagecount;i++){  
        if(pageno==i){  
            bar.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></a></li>");  
        }else{  
            bar.append("<li><a href='datapage.action?pageno="+i+"'>"+i+"</a></li>");  
        }  
    }  
}else{//��ҳ������11  
    if(pageno <=6){                         //��ǰҳСҳ����6ʱ  (ҳ��Ҫ��ǰ��Ľ���)  
        for(int i=2;i<=7;i++){  
            if(pageno==i){  
                bar.append("<li class='active'><a href='datapage.action?pageno="+i+"'>" +i+ "<span class='sr-only'>"+pageno+"</span></li>");  
            }else{  
                bar.append("<li><a href='datapage.action?pageno="+i+"'>"+i+"</a></li>");  
            }  
        }  
        bar.append("<li><span>....</span></li>");  
        bar.append("<li><a href='datapage.action?pageno="+(pagecount-1)+"'>"+(pagecount-1)+"</a></li>");  
    }else if(pageno>=pagecount-5){              //��ǰҳ�������ҳ-5ʱ Ҫ�����Ľ���  
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
//��������һҳ  
if(pageno == pagecount){  
  bar.append("<li class='active'><a href='datapage.action?pageno="+pagecount+"'>" +pagecount+ "<span class='sr-only'>"+pageno+"</span></a></li>")
//	bar.append("<li class='disabled'><a href='datapage.action?pageno="+pagecount+"'>" +pagecount+ "<span class='disabled'>Prev</span></a></li>")
       .append("<li class='disabled'><span class='disabled'>Next</span></li>");  
}else{  
    bar.append("<li><a href='datapage.action?pageno="+pagecount+"'>"+pagecount+"</a></li>")  
       .append("<li><a href='datapage.action?pageno="+(pageno+1)+"'>Next</a></li>");  
}
//��תҳ��
/*bar.append("<select style='height:33px;text-align: center;padding: 0.3em 0.5em;' onchange=\"location.href='datapage.action?pageno=this.value'\">");  
for(int i=1;i<=pagecount;i++){  
    if(pageno==i){  
        bar.append("<option value='"+i+"' selected='selected'>").append("��"+i+"ҳ").append("</option>");  
    }else{  
        bar.append("<option value='"+i+"'>").append("��"+i+"ҳ").append("</option>");  
    }  
}  
bar.append("</select>"); */
bar.append("</ul></nav>");
return bar.toString();  
		
		
	}
/*
 * ��ҳ1 ҳ����ʡ��
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
					//构建分页导航
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
					//构建分页导航
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
	                session.close(); // �ر�Session
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
