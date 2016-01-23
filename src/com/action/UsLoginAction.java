package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import com.service.DataService;

public class UsLoginAction extends AjaxActionSupport{
	private String uname;
	private String upass;
	private DataService dataService;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String login(){
	if (dataService==null) dataService=new DataService();
	if (dataService.getULogin(uname, upass)) {
		HttpSession session=request.getSession();
		session.setAttribute("user", uname);
		return SUCCESS;
	}
	return ERROR;	
		
	}
	//¼ì²éÒì²½µÇÂ¼£º
	public void clogin() throws IOException{
		PrintWriter out = response.getWriter();
		if (dataService==null) dataService=new DataService();
		if (dataService.getULogin(uname, upass)) out.print("true");
		else out.print("false");
	}

}
