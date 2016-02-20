package com.test;

import java.sql.ResultSet;
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
import com.dao.impl.SysUserDaoImpl;
import com.db.DbConnect;
import com.entity.BaseInfo;
import com.entity.Goods;
import com.entity.Hall;
import com.entity.Play;
import com.entity.Role;  
import com.entity.Ticket;
import com.entity.User;  
import com.entity.UserInfo;
import com.entity.UserVGood;
import com.model.GoodVPlayVHall;
import com.model.GoodsInfo;
import com.mysql.jdbc.PreparedStatement;
import com.tools.CacheClass;
import com.tools.CheckId;
import com.tools.Md5;
import com.tools.MyDate;
public class CopyOfUserTest {
	//恩  是我
    public static void main(String[] args) throws Exception {  
String m="55344";
CopyOfUserTest cy=new CopyOfUserTest();
System.out.print(CheckId.checkId(m));
    Session session=cy.getSession();
Transaction transaction=session.beginTransaction();
MyDate date=new MyDate();
/* 
UserInfo userInfo=new UserInfo();

userInfo.setContent("不是乱码");
User user=(User) session.get(User.class, "402881845277a4ff015277a500770003");
userInfo.setUser(user);
Goods goods=(Goods) session.get(Goods.class, "4028818552e3f60c0152e3f60dae0001");
userInfo.setGoods(goods);
goods.getUserInfo().add(userInfo);
userInfo.setUser(user);
session.save(userInfo);
transaction.commit();*/
     
  /* PreparedStatement psPreparedStatement= dbConnect.getPreparedStatemen("select distinct  content from uservgood where good_id=?");
   psPreparedStatement.setString(1, "4028818552e3f7720152e3f7746f0001");
   ResultSet rsResultSet=psPreparedStatement.executeQuery();
   while (rsResultSet.next()) {
	
	   System.out.println(rsResultSet.getString("content"));
}
   dbConnect.closeconn();*/
// 参考网址：http://www.cnblogs.com/wangchenyang/archive/2011/08/23/2150323.html
//已知 表中的某行的信息，插入影片
/*Goods goods=new Goods(); //Goods 为多的一方 BaseInfo为一的一方
goods.setSysname("什么啊");
goods.setDescript("啊");
//根据id 获取该信息
BaseInfo bseBaseInfo=(BaseInfo) session.get(BaseInfo.class,"40288183529bbd7301529bbd74830001");

System.out.print(bseBaseInfo.getCountry()+" "+bseBaseInfo.getBase_id());

goods.setBaseInfo(bseBaseInfo); //多的一方添加少的一方 
bseBaseInfo.getGoods().add(goods); //少的一方添加多的一方

session.save(bseBaseInfo);
transaction.commit();*/
 //该电影的场次
/*Play play1=new Play();
String timeString=new MyDate().toString();
//获取少的一方的信息
Goods goods=(Goods) session.get(Goods.class, "40288183529b5f4f01529b5f50840002");

play1.setGoods(goods);
play1.setPlay_time("2016-02-14 18:55");
goods.getPlay().add(play1);

session.save(goods);
transaction.commit();*/
//当该表含有多个外键，则可只在一个多的外键（即一的一方）的地方进行保存即可，如下：只保存hall即可 就不用session.save(其他了).
/*Play play1=new Play();
String timeString=new MyDate().toString();
//获取少的一方的信息
Goods goods=(Goods) session.get(Goods.class, "40288183529bbd7301529bbd748f0002");

play1.setPlay_time("2016-02-21 18:55");
play1.setGoods(goods);
goods.getPlay().add(play1);
Hall hall=(Hall) session.get(Hall.class, 1);
play1.setHall(hall);
hall.getPlay().add(play1);
//session.save(goods);
session.save(hall);
transaction.commit();*/

//增加电影票  一个场次可发放多张电影票，一个用户可买多张电影票   当每增加一张票的时候，play表中的 sell_num 也应加1，即卖出去的电影票
     /*Ticket ticket1=new Ticket();
     ticket1.setTicket_id(date.getYMDHMS()+date.getRandomN());
     ticket1.setCode(date.getYMDHMS()+date.getRandomN());
     ticket1.setCurrPrice(50.0);
     ticket1.setU_seat("5排6座");
     //获取场次 
     Play play1=(Play) session.get(Play.class, "4028818552ecd7940152ecd795cb0001");//星球大战
     //获取用户
     User user1=(User) session.get(User.class, "402881845277b20f015277b210430001");//lanqian
     ticket1.setPlay(play1);
     play1.getTickets().add(ticket1);
     ticket1.setUser(user1);
     user1.getTickets().add(ticket1);
     session.save(ticket1);
     session.save(play1);
     transaction.commit();*/
//分层
//Goods goods=(Goods) session.get(Goods.class, "40288183529b5f4f01529b5f50840002");
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