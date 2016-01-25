package com.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




import com.entity.Role;  
import com.entity.User;  
import com.tools.Md5;
  
public class UserTest {  
  
    public static void main(String[] args) {  
        UserTest test = new UserTest();  
       //添加用户 顺便赋予角色
       // test.getAddUserToRole();
        //仅仅添加用户
       // test.addUser();
        //仅仅添加用户角色
        test.addSoleRole();
    }
    //get factory
 public SessionFactory HibernateSessionFactory(){
	 SessionFactory factory=new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	 return factory;
	 
 }
 //get session
 public Session getSession() {
	 Session session=HibernateSessionFactory().openSession();
	 return session;
}
 public void  getAddUserToRole() {
	 addUserToRole("student");
}
 public User getUser(){
	
	 
	 
	 
	 return null;
	 
 }
 public void addSoleRole(){
	 Session session=getSession();
	 Transaction transaction=session.beginTransaction();
	 Role role3=new Role();
	 role3.setRolename("manager");
	 role3.setDescription("普通管理");
	 session.save(role3);
	 transaction.commit();
	 session.close();
 }
	public void addUserToRole(String uname) {  
    	SessionFactory factory=new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    	Session session =factory.openSession();
    	Transaction tran=session.beginTransaction();  
       /* User xhg = (User) session.get("com.entity.User",  
                "402881e7394e8f4501394e8f476d0000");  
        Role sys = (Role) session.get("com.entity.Role",  
                "402881e4393a6f3a01393a6f3c1a0000");  
        //xhg.getRoles().add(sys); 
*/        
        User u1 = new User("tadmin");
        u1.setCreateDate(new Date());//���ô���ʱ��
        u1.setPassword(Md5.getMD5("123456"));
       /* Role role1 = new Role("administrator6");
        session.save(role1);
        Role role2 = new Role("students6");
        session.save(role2);*/
        Set<Role> u1Roles = new HashSet<Role>();
        Role role1=new Role();
        	role1.setRolename("teacher");
        	role1.setDescription("这是老师");
        	session.save(role1);
        Role role2 = new Role();
        	role2.setRolename("admin");
        	role2.setDescription("这是管理员");
        	session.save(role2);
        	//���û���ӽ�ɫ����ʦ�͹���Ա�Ľ�ɫ��
        u1Roles.add(role1);
        u1Roles.add(role2);
        u1.setRoles(u1Roles);
        session.save(u1);
        tran.commit();
    	session.close();
    }  
	 public void insert(){
	        Session session=HibernateSessionFactory().openSession();
	        Transaction transaction=session.beginTransaction();
	        try {
	            transaction.begin();
	            User user=new User();
	            user.setUsername("����");
	            
	            Role role=new Role();
	            role.setRolename("����Ա");
	            Set<Role> roles=new HashSet<Role>();
	            roles.add(role);
	            user.setRoles(roles);
	            session.persist(user);
	            transaction.commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            transaction.rollback();
	        }
	    }
	    
	    
	    public void select(){
	    	Session session=HibernateSessionFactory().openSession();
	        User user=(User) session.get(User.class, 1);
	        System.out.println(user.getUsername());
	        Set<Role> roles=user.getRoles();
	        for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext();) {
	            Role role = (Role) iterator.next();
	            System.out.println(role.getUsers());
	        }
	    }
    public void addRole() {  
    	SessionFactory factory=new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    	Session session =factory.openSession();
        session.beginTransaction();  
        Role role = new Role();  
        role.setRolename("ϵͳ����Ա");  
        role.setOrdernum(1);  
        role.setDescription("����ϵͳά���Ľ�ɫ");  
        session.save(role);  
        session.getTransaction().commit();  
        session.close();  
    }  
  
    public void addUser() {  
    	SessionFactory factory=new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    	Session session =factory.openSession();
        session.beginTransaction();  
        User user = new User();  
        user.setUsername("lanqian");  
        user.setPassword("1994");  
        session.save(user);  
        session.getTransaction().commit();  
        session.close();  
    }  
  
}  