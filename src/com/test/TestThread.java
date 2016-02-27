package com.test;


public class TestThread implements Runnable{
	private String nameString;
	private Object prep;
	private Object self;
	public TestThread(String nameString, Object prep, Object self) {
		super();
		this.nameString = nameString;
		this.prep = prep;
		this.self = self;
	}
	public TestThread(String nameString) {
		super();
		this.nameString = nameString;
	}
	public static void main(String[] args){
		Object a=new Object();
		Object b=new Object();
		Object c=new Object();
		TestThread aTestThread=new TestThread("A",c,a);
		TestThread bTestThread=new TestThread("B",b,b);
		TestThread cTestThread=new TestThread("C",a,c);
		
		new Thread(aTestThread).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(bTestThread).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(cTestThread).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		int count=10;
		// TODO Auto-generated method stub
		while(count>0) {
			synchronized (prep) {
				synchronized (self) {
					System.out.println(nameString);
					count--;
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					self.notify(); //通知
					try {
						prep.wait();//等待
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
