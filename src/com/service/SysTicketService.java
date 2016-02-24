package com.service;

import java.util.List;

import com.dao.impl.SysTicketDaoImpl;

public class SysTicketService {
private SysTicketDaoImpl sysTicketDaoImpl;

public SysTicketDaoImpl getSysTicketDaoImpl() {
	return sysTicketDaoImpl;
}

public void setSysTicketDaoImpl(SysTicketDaoImpl sysTicketDaoImpl) {
	this.sysTicketDaoImpl = sysTicketDaoImpl;
}

public List findByTimeRoom(String room,String time){
	
	
	return sysTicketDaoImpl.getSeats(room, time);
	
}
public List findByTimeRoom(String id){
	 List<Object[]> list=sysTicketDaoImpl.getPlayId(id);
	 if (list.size()!=0&&list.size()==1) {
		 String[]  data=new String[2];
		 for (Object[] o : list) {
				data[0]=(String)o[0];
				data[1]=(String)o[1];
			}
		return sysTicketDaoImpl.getSeats(data[0], data[1]);
	}
	return null;
	
}

}
