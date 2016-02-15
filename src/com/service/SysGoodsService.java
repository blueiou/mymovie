package com.service;

import java.util.List;

import com.dao.DataPageDao;
import com.dao.PagingDao;
import com.dao.impl.PagingDaoImpl;
import com.dao.impl.SysGoodsDaoImpl;
import com.entity.Goods;
import com.entity.Page;
import com.entity.Play;
import com.tools.PulginsException;

public class SysGoodsService {
	private PagingDaoImpl pagingDaoImpl;
	private SysGoodsDaoImpl sysGoodsDaoImpl;
	private Goods goods;
	private Play play;
	public SysGoodsDaoImpl getSysGoodsDaoImpl() {
		return sysGoodsDaoImpl;
	}

	public void setSysGoodsDaoImpl(SysGoodsDaoImpl sysGoodsDaoImpl) {
		this.sysGoodsDaoImpl = sysGoodsDaoImpl;
	}

	public PagingDaoImpl getPagingDaoImpl() {
		return pagingDaoImpl;
	}

	public void setPagingDaoImpl(PagingDaoImpl pagingDaoImpl) {
		this.pagingDaoImpl = pagingDaoImpl;
	}

//	DataPageDao dataPageDao=new DataPageDao();
	private Page p;

		public Page findShowing(int pageno,int pagesize){
	if (p==null)  p=new Page();
	
			p=sysGoodsDaoImpl.getPageList(pageno, pagesize, Goods.class,1);
			int pagecount=p.getPagecount();
			if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
			else p.setPagelast(pageno);
			if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
			else p.setPageNext(pageno);
			if (pageno>pagecount) p.setPageno(pagecount);
			return p;

		}
		public Page findPrePage(int pageno,int pagesize){
			if (p==null)  p=new Page();
					p=sysGoodsDaoImpl.getPageList(pageno, pagesize, Goods.class,0);
					int pagecount=p.getPagecount();
					if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
					else p.setPagelast(pageno);
					if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
					else p.setPageNext(pageno);
					
					if (pageno>pagecount) p.setPageno(pagecount);
					return p;

				}
		public int test(){
			return pagingDaoImpl.getCount(1);
		}
		
		public Goods findById(String id) throws PulginsException {
			List<Goods> list=sysGoodsDaoImpl.getGoodById(id);
			if (list.size()==0) {
				throw new PulginsException("没有查找到该影片");
			}
			else goods=list.get(0);
			
			return goods;
		}
		
		public List<Play> findByTime() throws PulginsException{
			
			List<Play> list=sysGoodsDaoImpl.getById("");
			if (list.size()==0) {
				throw new PulginsException("没有该场次");
			}
			return list;
		}
		
}
