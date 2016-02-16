package com.test;

import com.db.DbConnect;
import com.entity.Tb_datas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.Result;
import com.tools.CheckId;
import com.tools.JsonTools;
import com.tools.WriteFile;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


class MyThread implements Runnable{
	 
    private int ticket = 10;  //5��Ʊ
 
    public void run() {
        for (int i=0; i<=20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName()+ "������Ʊ"+this.ticket--);
            }
        }
    }
}
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static int getRandom(int min, int max)
	{
	Random random = new Random();
	int s = random.nextInt(max) % (max - min + 1) + min;
	return s;
	}
		// TODO Auto-generated method stub
	  public static boolean isAlphanumeric(String str) {
	         return StringUtils.isAlphanumeric(str);
	     }	
	/*
	 * 
	 * 
	 * ������ʽ��ֻ��������ĸ,����,�»���
	 * str.matches("[A-Za-z0-9_]+");
        str.matches("\\w+")
	 */
public static void main(String[] args) throws SQLException, Exception {
	
	System.out.println("�����TEST.class:"+Test.class);
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://rdsxlz2016testpublic.mysql.rds.aliyuncs.com:3306/gllk";
	String nameString="gllk";
	String password="gllk2015";
	
	Class.forName(driver);
	System.out.print("������ɹ�");
	Connection connection=(Connection) DriverManager.getConnection(url,nameString,password);

//PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("update  lk_user_auth set rmbstate=0 where mobile='18378338373'");
/*PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("update  lk_user_auth set isdisabled=0 where mobile='18378338373'");

	//preparedStatement.setInt(1, 0);
	int i= preparedStatement.executeUpdate();
	if (i>0) {
		System.out.print("���³ɹ�");
	} else {
		System.out.print("����ʧ��");
	}*/
	/*      ��ѯ�û�*/
//PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("select username,encryptedPassword from  lk_user_auth  where purview>100");
PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("select * from  lk_user_auth  limit 6,55");
	ResultSet rsResult= preparedStatement.executeQuery();
	int i=0;
	String tempsString="";
	//HashSet hs =new HashSet();
	String[] hs = new String[7];
	while (rsResult.next()) {
		
	/*	System.out.print("��"+i+"���û�:"+rsResult.getString("username")+" ");
		System.out.print(rsResult.getString("encryptedPassword")+" ");
		System.out.print(rsResult.getString("mobile"));	
		System.out.println();*/
		String temp="��"+(i+1)+"���û�:"+rsResult.getString("username")+" "+rsResult.getString("encryptedPassword")+" "+rsResult.getString("mobile")+"\n";
		//hs[i]=temp;
		tempsString+=temp+"\r\n";
		//System.out.println(hs[i]);
		i++;
	}
	
	//WriteFile.outFile(hs);
	WriteFile.writeFile(tempsString);
	/* MyThread my = new MyThread();
     new Thread(my, "1�Ŵ���").start();
     new Thread(my, "2�Ŵ���").start();
     new Thread(my, "3�Ŵ���").start();*/
     //System.out.print("12121_121145657687sdgsf".matches("[A-Za-z0-9_]+"));
     
	
	//����session����	
	/*SessionFactory factory=new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	Session session =factory.openSession();
	Transaction tran=session.beginTransaction();
	Tb_datas tb_datas=new Tb_datas();
	tb_datas.setData("11222121221221212221211212122112112221112211345");
	
	session.save(tb_datas);
	tran.commit();
	session.close();*/		
			
			
			/*int index1="11222121221221212221211212122112112221112211".indexOf("11222121221221212221211212122112112221112211");
			
			if (index1!=-1) {
				 System.out.print(index1);
			 }
			*/
			
			//String dataString="211121111111112222221212212211111111122121111122121121221112";
			//dataString=dataString.substring(1, 60);
			//System.out.print(dataString.length());
			/*int  length = "abcdbe".indexOf("121212121e")+1;//��Ϊ�Ǵӿ�ʼ�������Լ�1
			int  end   = length+"bc".length()-1;//ȡ�ý���λ��
			System.out.print("��ʼλ�ã�"+length+"��  ����λ�ã�"+end);*/
		//	System.out.print("11121211292121221221212221211212122112112221112211".substring(9));
	
			/*		
			//System.out.print(getRandom(46, 60));
			List datasList=new ArrayList();
			for (int k = 0; k < 80; k++) {
				StringBuffer array = new StringBuffer();
				for (int i = 1; i <3; i++) {
					array.append(i);
				}
				int length = array.length();
				int n=57;
				StringBuffer str = new StringBuffer();
				for (int i = 0; i < n; i++) {
					// ������λ�õ��ַ�
					char c = array.charAt((int) (Math.random() * length));
					str.append(c);
					Data data=new Data();
					data.setData(str.toString());
					datasList.add(data);
				}	
				//System.out.println(str.toString()+"\n");
				
				
			}
			String daString="";
			DbConnect dbConnect=new DbConnect();
		     for(int i=0;i<datasList.size();i++){ 
		 
		    	 Data data=(Data)datasList.get(i);
		    	 daString=data.getData();
		    	 if (57==daString.length()) {
		    		 String sql="insert into tb_datas(data) values('"+data.getData()+"')";
		 			dbConnect.getStatement().executeUpdate(sql);	
				}
		
		     }*/
}
		
}
