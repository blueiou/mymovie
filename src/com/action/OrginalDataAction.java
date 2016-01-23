package com.action;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.dao.DataPageDao;
import com.entity.Page;
import com.service.DataPageService;
import com.tools.CheckId;


public class OrginalDataAction extends AjaxActionSupport {
	 DataPageService pageService=new DataPageService();
	private Page page;
	//private int pageno=1;
	//private String pagenoString="1";

	private int pagesize=5;

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/*	public String getPagenoString() {
		return pagenoString;
	}

	public void setPagenoString(String pagenoString) {
		this.pagenoString = pagenoString;
	}*/

		public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
//	
	public String execute() {
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){ return "signin";}
		int  pageno=1;
		//String pagenoString =;
	//	System.out.print(CheckId.checkPage(pagenoString));
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CheckId.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
			
		} 
		page=pageService.findpage(pageno, pagesize);
		request.setAttribute("page", page);
		return SUCCESS;
		
	}
}
