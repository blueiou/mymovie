package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.entity.Page;
import com.service.StudentBO;
import com.service.SysGoodsService;
import com.tools.CheckId;

public class TestSSHAction extends AjaxActionSupport {
	private StudentBO sBo;
	private SysGoodsService sGoods;
	private Page page;
	private int pagesize=5;
	public SysGoodsService getsGoods() {
		return sGoods;
	}
	public void setsGoods(SysGoodsService sGoods) {
		this.sGoods = sGoods;
	}
	public StudentBO getsBo() {
		return sBo;
	}
	@Resource(name="userService")
	public void setsBo(StudentBO sBo) {
		this.sBo = sBo;
	}
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

		public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public String execute() {
		int  pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CheckId.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		} 
		
		/*//page=sBo.findpage(pageno, pagesize);
		
		request.setAttribute("page", page);
		return SUCCESS;*/
		
		
		page=sGoods.findpage(pageno, pagesize);
		request.setAttribute("page", page);
		return "goodslist";
	}	
	
	
	
	
}
