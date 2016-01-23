package com.dao;
import com.entity.Page;
import com.entity.Student;

public interface DataPageDaoT {
	/*private HibernateTemplate hibernateTemplate;
	@Resource
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	public Page getpagelist(int pageno ,int pagesize);
	public void saveStu(Student stu);
	
}
