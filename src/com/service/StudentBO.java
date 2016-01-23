package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.DataPageDaoT;
import com.entity.Page;
import com.entity.Student;

public class StudentBO {
private DataPageDaoT dataPageDaoT;
private Page p;
public DataPageDaoT getDataPageDaoT() {
		return dataPageDaoT;
	}
	public void setDataPageDaoT(DataPageDaoT dataPageDaoT) {
		this.dataPageDaoT = dataPageDaoT;
	}
	public Page findpage(int pageno,int pagesize){
		if (p==null)  p=new Page();
				p=dataPageDaoT.getpagelist(pageno, pagesize);
				int pagecount=p.getPagecount();
				if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
				else p.setPagelast(pageno);
				if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
				else p.setPageNext(pageno);
				
				if (pageno>pagecount) p.setPageno(pagecount);
				return p;
			
	}
/*public void saveStu(Student stu) {
	saveStu( stu);
	
}*/

}















