package com.test;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.impl.SysGoodsDaoImpl;
import com.entity.Play;
import com.model.PlayByMid;
//类中测试方法 已经注入到spring中的
public class TestApplication {
	public static void main(String args[]){
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	SysGoodsDaoImpl sysGoodsDaoImpl=(SysGoodsDaoImpl) act.getBean("SysGoodsDaoImpl");
	List<PlayByMid> lis= sysGoodsDaoImpl.getByMId("40288183529b5f4f01529b5f50840002","2016-02-20%");
	//List<PlayByMid> lis= sysGoodsDaoImpl.test();
	for (PlayByMid playByMid : lis) {
		System.out.println(playByMid.getLanguage());
	}
	System.out.println();
	}
}
