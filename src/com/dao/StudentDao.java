package com.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Student;
public class StudentDao extends HibernateDaoSupport {	
private static final Log log = LogFactory.getLog(StudentDao.class);
/*
 *     
 */

public void save(Student stu) {
	        log.debug("saving Student instance");
	        try {
	            getHibernateTemplate().save(stu);
	            log.debug("save successful");
	        } catch (RuntimeException re) {
	            log.error("save failed", re);
	            throw re;
	        }
	    }
/*
 * 
 */
public void update(Student stu){
	log.debug("updating Student instance");
	try{
		getHibernateTemplate().update(stu);
		log.debug("update successful");
	}catch (RuntimeException re) {
		log.error("update failed", re);
        throw re;
		// TODO: handle exception
	}
}
/*
 *
 */
public void delete(Student stu) {
	        log.debug("deleting Student instance");
	        try {
	            getHibernateTemplate().delete(stu);
	            log.debug("delete successful");
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
	    }
/*
 * 
 *   
 */
public Student findById(java.lang.Integer id) {
	        log.debug("getting Student instance with id: " + id);
	        try {
	            Student instance = (Student) getHibernateTemplate().get(Student.class, id);//Student.class涓鸿矾寰�
	            return instance;
	        } catch (RuntimeException re) {
	            log.error("get failed", re);
	            throw re;
	        }
	        
	    }
/*
 * 
 */
public List findByProperty(String propertyName, Object value) {
	log.debug("finding Student instance with property: " + propertyName+ ", value: " + value);
	try {
		String query = "from Student as model where model."+ propertyName + "= ?";
		return getHibernateTemplate().find(query, value);
	} catch (RuntimeException re) {
		log.error("find by property name failed", re);
		throw re;
	}
}
/*
 * list count
 */

public int getRows(){
	log.debug("finding rows from Student instance");
	try{
		String query="from Student";
		List<Student> list=getHibernateTemplate().find(query);
		log.debug("finding rows success");
		return list.size();
	}catch (RuntimeException re) {
		log.error("find by Student failed", re);
		throw re;
	}
}
/*
 * iterator   getCount()
 */
public Integer getCount(){
	Integer count;
	log.debug("iterate find counts");
	try{
		String hql="from Student";
		count=((Long)getHibernateTemplate().iterate(hql).next()).intValue();
		return count;
	}catch(RuntimeException re){
		log.error("find by Student failed", re);
		throw re;
	}
}




/*
 * 

public List findAll(){
	log.debug("finding all students from Student instance");
	try{
		String query="from Student";
		List<Student> list=getHibernateTemplate().find(query);
		log.debug("finding all students success");
		return list;
	}catch(RuntimeException re){
		log.error("find all by Student failed", re);
		throw re;
	}
	
}
 */
/*
 *
 * 

public List findOnePage(final int offset,final int pagesize){
	log.debug("finding onepage from Student instance");
	try{
		String hql="from Student";
	//	List li= getHibernateTemplate().createQuery(hql).setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
	//	return li;
		final StringBuffer sb=new StringBuffer();
	
		sb.append(hql);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				List list=null;
				Query query=s.createQuery(sb.toString());
				if(offset != 0 && pagesize != 0){
				query.setFirstResult((offset - 1) * pagesize);
				query.setMaxResults(pagesize);
				list=query.list();
				// TODO Auto-generated method stub
				s.close();
				return list;
			}
				else{
					Query query1=s.createQuery(sb.toString());
					List rs=query1.list();	
					s.close();
					return rs;	
				}
			}
		
		});
	}catch(RuntimeException re){
		log.error("finding onepage failed", re);
		throw re;
	}
	
}
 */
public static StudentDao getFromApplicationContext(ApplicationContext ctx) {
    return (StudentDao) ctx.getBean("studentdao");
}	    

}
