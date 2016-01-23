package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import com.service.DataService;

public class DeleteDataAction extends AjaxActionSupport{

private String did;
DataService dataService=new DataService();

public String getDid() {
	return did;
}


public void setDid(String did) {
	this.did = did;
}
public void del() throws IOException{
	HttpSession session=request.getSession();
	if(session.getAttribute("user")!=null){
	
	PrintWriter out = response.getWriter();
	if (did!=null&&!did.equals("")) {
	if(	dataService.getDel(did)){
		out.print("true");
	}
	} else {
		out.print("false");
	}
}
}
}
