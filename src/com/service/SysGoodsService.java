package com.service;

import com.dao.DataPageDao;
import com.dao.PagingDao;
import com.dao.impl.PagingDaoImpl;
import com.entity.Goods;
import com.entity.Page;

public class SysGoodsService {
	private PagingDaoImpl pagingDaoImpl;
	
	public PagingDaoImpl getPagingDaoImpl() {
		return pagingDaoImpl;
	}

	public void setPagingDaoImpl(PagingDaoImpl pagingDaoImpl) {
		this.pagingDaoImpl = pagingDaoImpl;
	}

//	DataPageDao dataPageDao=new DataPageDao();
	private Page p;

		public Page findpage(int pageno,int pagesize){
	if (p==null)  p=new Page();
	
			p=pagingDaoImpl.getPageList(pageno, pagesize, Goods.class);
//			int rowcount=p.getRowcount();
			int pagecount=p.getPagecount();
			if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
			else p.setPagelast(pageno);
			if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
			else p.setPageNext(pageno);
			
			if (pageno>pagecount) p.setPageno(pagecount);
			//System.out.print(p.getPageno());
			return p;

		}
}
