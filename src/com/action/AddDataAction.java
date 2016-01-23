package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import com.service.DataService;

public class AddDataAction extends AjaxActionSupport{

private String udata;
private DataService dataService;
public String getUdata() {
	return udata;
}

public void setUdata(String udata) {
	this.udata = udata;
}

public void addd() throws IOException{
	HttpSession session=request.getSession();
	if(session.getAttribute("user")!=null){
	PrintWriter out = response.getWriter();
	if (dataService==null) dataService=new DataService();
	if (dataService.getAddData(udata)) {
		out.print("true");
	} else {
		out.print("false");
	}
	}	
}


}
