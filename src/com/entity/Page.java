package com.entity;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
private	int	pagecount ;//每页记录数
private	int	 pageno ;//当前页
private	int	 pagesize ;
private	int	pagelast ;
private	int	 pageNext ;
private	List<Tb_datas> stulist;
private int rowcount;
//private String sbB;

//分页导航二

private String sb2;


public String getSb2() {
	return sb2;
}
public void setSb2(String sb2) {
	this.sb2 = sb2;
}

public int getRowcount() {
	return rowcount;
}
public void setRowcount(int rowcount) {
	this.rowcount = rowcount;
}
public Page(){
	
}

public int getPagecount() {
	return pagecount;
}

public void setPagecount(int pagecount) {
	this.pagecount = pagecount;
}
public int getPageno() {
	return pageno;
}
public void setPageno(int pageno) {
	this.pageno = pageno;
}
public int getPagesize() {
	return pagesize;
}
public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}
public int getPagelast() {
	return pagelast;
}
public void setPagelast(int pagelast) {
	this.pagelast = pagelast;
}
public int getPageNext() {
	return pageNext;
}
public void setPageNext(int pageNext) {
	this.pageNext = pageNext;
}
public List<Tb_datas> getStulist() {
	return stulist;
}
public void setStulist(List<Tb_datas> stulist) {
	this.stulist = stulist;
}
public Page( int pagecount ,int pageno,int pagesize,List<Tb_datas> stuList,int rowcount,String sb2){
	this.pagecount=pagecount;
	this.pageno=pageno;
	this.pagesize=pagesize;
	this.stulist=stuList;
	this.rowcount=rowcount;
  this.sb2=sb2;
}



}
