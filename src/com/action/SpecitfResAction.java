package com.action;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.service.DataService;
public class SpecitfResAction extends AjaxActionSupport{

	public String params;
	public String sChar;
DataService dataService=new DataService();
	
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getsChar() {
		return sChar;
	}
	public void setsChar(String sChar) {
		this.sChar = sChar;
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			 HttpSession session=request.getSession();
			 if(session.getAttribute("user")==null){ return "signin";}
			 if(params!=null&&sChar!=null&&params!="")
				{
					  try {
							List lastSSlList=dataService.getSpecifySearchList(params.trim(), sChar);
							// session.setAttribute("zdparams", params);
							 request.setAttribute("zdparams", params);
							request.setAttribute("lastSSlList", lastSSlList);
							return SUCCESS;
						
					  } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
				}
	
			 return ERROR;
	}
	
}
