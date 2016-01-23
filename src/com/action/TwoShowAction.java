package com.action;


import javax.servlet.http.HttpSession;


import com.service.DataService;




public class TwoShowAction extends AjaxActionSupport{
	DataService dataService=new DataService();
public String data;
public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public String showData(){
	 response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){ return "signin";}
if (data!=null) {
	 try {
		char[][] ds=dataService.getRegroupList(data);
		if(ds!=null){
		//	session.setAttribute("newchar2", ds);;
		request.setAttribute("newchar2", ds);
			
			
						return SUCCESS;}
		}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


		return ERROR;
}
}



