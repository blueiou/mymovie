package com.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.entity.Page;
import com.service.StudentBO;
import com.service.SysGoodsService;
import com.tools.CacheClass;
import com.tools.CheckId;
import com.tools.Functions;

public class EntrieGoodAction extends AjaxActionSupport {
	private StudentBO sBo;
	private SysGoodsService sGoods;
	private Page page;
	private Map<String, Object> dataMap;
	private int pagesize=6;
	@Resource(name="SysGoodsService")
	public SysGoodsService getsGoods() {
		return sGoods;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
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
	//获取公共数据
	public int getPramString() {
		int  pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CheckId.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		} 
		return pageno;
	}
	
	public String sysGoods(){
		String mString=request.getParameter("m");
		int m=-1;
		if (CacheClass.isEmpty(mString)) m=1510;
		else {
			m=Integer.parseInt(mString);
		}
		System.out.print(mString);
		switch (m) {
		case Functions.GET_GOODS_OPERATION_LIST0: 	
			return mvList();
			case Functions.GET_GOODS_OPERATION_LIST1:
				return preList();
		default: 
			return ERROR;
		}
	}
	
	
	public String execute() {
		
		return "goodslist";
	}	
	public HashMap<String, Object> mvList2(){
		dataMap=new HashMap<String, Object>();
		
		int  pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CheckId.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		} 
		page=sGoods.findShowing(pageno, pagesize);
		
		dataMap.put("smvlist", page);
		dataMap.put("success", true);
		return (HashMap<String, Object>) dataMap;
	}
	
	public String mvList(){
		dataMap=new HashMap<String, Object>();
		
		int  pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CheckId.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		} 
		page=sGoods.findShowing(pageno, pagesize);
		dataMap.put("smvlist", page);
		dataMap.put("success", true);
		return SUCCESS;
	}
	public String preList(){
	dataMap=new HashMap<String, Object>();
		int  pageno=getPramString();
		page=sGoods.findPrePage(pageno, pagesize);
		dataMap.put("pmvlist", page);
		dataMap.put("success", true);
		return SUCCESS;
	}
	/*public String */
	
	
	public void test(){
		sGoods.test();
		System.out.print(sGoods.test());
	}
	
	
}
