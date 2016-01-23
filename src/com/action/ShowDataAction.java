package com.action;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.entity.Data;
import com.service.DataService;
public class ShowDataAction extends AjaxActionSupport{
DataService dataService=new DataService();
 public String param;
public String getParam() {
	return param;
}
public void setParam(String param) {
	this.param = param;
}

 public String show() {
	 response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		 
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){ return "signin";}
	 if(param!=null&&param!="")
		{
		 if (param.equals("")) {
			return ERROR;
		}
		 else {
				  List<Data> dataslist=dataService.getDatasList(param.trim());
				  request.setAttribute("param", param);
					request.setAttribute("dataslist", dataslist);
					return SUCCESS;
			  
		  
		 }	  
		}
	
		
		 return ERROR;
 }
 

}
