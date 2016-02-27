package com.test;

public class A {
	public A(){
		System.out.println("A3");
	}
	{
		System.out.println("A1");
		
	}
	static {
		System.out.println("A2");
	}
	public static void main(String[] args){
		
		System.out.println("2016-02-27 09:55:00.0".substring(11,16));
		
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("A类的你好");
	}
}
class B extends A{
	
	public B(){
		System.out.println("B3");
	}
	{
		System.out.println("B1");
		
	}
	static {
		System.out.println("B2");
	}
	
public void print(){
	System.out.println("B类的你好");
}
	
}