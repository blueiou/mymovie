package com.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.dao.impl.PagingDaoImpl;
import com.entity.BaseInfo;
import com.entity.Goods;
import com.entity.Role;  
import com.entity.User;  
import com.model.GoodsInfo;
import com.tools.CacheClass;
import com.tools.CheckId;
import com.tools.Md5;
  
public class CopyOfUserTest {  
  
    public static void main(String[] args) {  
String m="55344";
CopyOfUserTest cy=new CopyOfUserTest();
System.out.print(CheckId.checkId(m));
    Session session=cy.getSession();
Transaction transaction=session.beginTransaction();


/*
BaseInfo bseBaseInfo=new BaseInfo();
bseBaseInfo.setBase_id("40288183529bbd7301529bbd74830001");*/
/*bseBaseInfo.setContry("中国");
bseBaseInfo.setLanguage("中文");*/
//session.save(bseBaseInfo);
Goods goods=new Goods();

goods.setSysname("叶问3");
goods.setDescript("1959年，叶问（甄子丹饰）与张永成（熊黛林饰）将大儿子叶准送回广东，小儿子叶正继续在香港读书。在与马鲸笙（谭耀文饰）与其老板（泰森饰）所带领的帮派抗争的过程中，叶问带领着自己的弟子保卫了小学，并结识了依靠拉车和在地下赌场斗武为生的张天志（张晋饰），二人惺惺相惜。然而此时，自称 “咏春正宗”的张天志却向叶问公开宣战，要为自己新开的武馆争取名誉。可是张永成突然病危，让叶问不得不肩负起照顾妻儿的责任。面对家庭和武术，叶问究竟会作何选择？他是否会应战张天志，夺回属于他 “咏春正宗”的头衔？");
BaseInfo bseBaseInfo=(BaseInfo) session.get(BaseInfo.class,"40288183529bbd7301529bbd74830001");

//bseBaseInfo.setBase_id("40288183529bbd7301529bbd74830001");

System.out.print(bseBaseInfo.getCountry()+" "+bseBaseInfo.getBase_id());
/*Set<Goods> goods2=new HashSet<>();
goods2.add(goods);*/
goods.setBaseInfo(bseBaseInfo);
bseBaseInfo.getGoods().add(goods);
//System.out.print(goods2.iterator().hasNext());
//bseBaseInfo.getGoods().add(goods);
session.save(bseBaseInfo);
transaction.commit();
    	
    /*	
     CopyOfUserTest test = new CopyOfUserTest(); 
        Criteria criteria=test.getSession().createCriteria(Goods.class);
        ProjectionList pList=Projections.projectionList();
		//pList.add(Projections.rowCount());
		pList.add(Projections.groupProperty("stamp"));
		pList.add(Projections.sum("stamp"));
		criteria.setProjection(pList);
		List<Object[]> goods = criteria.list();
		System.out.print(goods.get(1)[1]);*/
	/*for (Object[] objects : goods) {
		System.out.println("object:"+objects[0]);
		System.out.println("object:"+objects[1]);
		
	}*/
			
        
        
       /* 
        criteria.setProjection(Projections.groupProperty("stamp"));
        List<Integer> goods = criteria.list();
        
			System.out.println("object:"+goods.get(0));*/
		
       //添加用户 顺便赋予角色
       // test.getAddUserToRole();
        //仅仅添加用户
       // test.addUser();
        //仅仅添加用户角色
        //test.addSoleRole();
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