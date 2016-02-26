package com.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.entity.Goods;
import com.entity.Page;
import com.entity.Play;
import com.service.SysGoodsService;
import com.tools.CacheClass;
import com.tools.Functions;
import com.tools.PulginsException;
public class EntrieGoodAction extends AjaxActionSupport {
	private SysGoodsService sGoods;
	private Page page;
	private Goods goodDescri;
	private Map<String, Object> dataMap;
	private int pagesize=6;
	private Object reply;
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
	public Goods getGoodDescri() {
		return goodDescri;
	}
	public void setGoodDescri(Goods goodDescri) {
		this.goodDescri = goodDescri;
	}
	//获取当前页
	public int getPramString() {
		int  pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CacheClass.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		} 
		return pageno;
	}
	public String execute() throws PulginsException{
	String mString=request.getParameter("m");
		int m=-1;
		if (CacheClass.isEmpty(mString)||!CacheClass.isNumValue(mString)) m=1510;
		else {
			m=Integer.parseInt(mString);
		}
		System.out.print("m的值为："+mString);
		switch (m) {
		case Functions.GET_GOODS_OPERATION_LIST0:
			return mvList();
			case Functions.GET_GOODS_OPERATION_LIST1:
				return preList();
			case Functions.GET_GOODS_OPERATION_INFO:
				return	exmapleById();
			case Functions.GET_GOODS_OPERATION_PlayTime:
				return play();
				case Functions.GET_GOODS_OPERATION_PlayTime_ById:
					return playByMid();
		default: 
			return ERROR;
		}
	}	
	//获取正在上映影片
	public String mvList(){
		if (dataMap==null)  dataMap=new HashMap<String, Object>();
		int  pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CacheClass.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		} 
		page=sGoods.findShowing(pageno, pagesize);
		dataMap.put("smvlist", page);
		dataMap.put("success", true);
		return SUCCESS;
	}
	//获取预备上映影片
	public String preList(){
		if (dataMap==null)  dataMap=new HashMap<String, Object>();
		int  pageno=getPramString();
		page=sGoods.findPrePage(pageno, pagesize);
		dataMap.put("pmvlist", page);
		dataMap.put("success", true);
		return SUCCESS;
	}
  //影片详情介绍
	public String exmapleById() throws PulginsException{
	if (dataMap==null) 	dataMap=new HashMap<String, Object>();
		if (sGoods.findById(request.getParameter("id"))==null) {
			System.out.print("enter");
			return ERROR;
		}
		else {
			goodDescri=sGoods.findById(request.getParameter("id"));
			dataMap.put("goodDescri", goodDescri);
			dataMap.put("success", true);
			return SUCCESS;
		}
	}
	//获取某天放映的全部电影列表
	public String play() throws PulginsException{
		List<Play> plays;
		if (dataMap==null) 	dataMap=new HashMap<String, Object>();
		plays=sGoods.findByTime(request.getParameter("playTime"));
		reply=plays;
		dataMap.put("reply", reply);
		dataMap.put("success", true);
		return SUCCESS;
	}
	//获取某天放映的<特定>的电影列表
	public String playByMid() throws PulginsException{
		List plays;
		if (dataMap==null) 	dataMap=new HashMap<String, Object>();
		plays=sGoods.findByTimeMid(request.getParameter("mid").trim(), request.getParameter("playTime").trim());
		reply=plays;
		dataMap.put("reply", reply);
		dataMap.put("success", true);
	return "playbyid";
	//	return SUCCESS;
	}
	/*public String  测试*/
	public void test(){
		reply=sGoods.findByTime2();
		dataMap.put("REPLY", reply);
		dataMap.put("success", true);
	}
}
