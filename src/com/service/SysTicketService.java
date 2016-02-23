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


}
