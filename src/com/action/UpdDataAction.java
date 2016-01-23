package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import com.service.DataService;

public class UpdDataAction extends AjaxActionSupport{

	private String datasString;
 private String did;
 DataService dataService=new DataService();
	public String getDid() {
	return did;
}

public void setDid(String did) {
	this.did = did;
}

	public String getDatasString() {
		return datasString;
	}

	public void setDatasString(String datasString) {
		this.datasString = datasString;
	}
public void upd() throws IOException{
	
	HttpSession session=request.getSession();
	if(session.getAttribute("user")!=null){
		PrintWriter out = response.getWriter();
	if(did!=null&&datasString!=null&&!datasString.equals("")&&!did.equals(""))
	{
		if (dataService.getUpdat(datasString, did)) {
			out.print("true");
		} else {
			out.print("false");
		}
	}
	}
}
	

}
