package com.test;

public class TestString {

	final static double PI=3.1415;
	public static void main(String[] args) {
		/*StaticTest st1=new StaticTest();
    	StaticTest st2=new StaticTest();
    	st1.method2("HAN");*/
		
		/*****定义要用于转置的二维数组*******/
		int arr2D[][]={{1,2,3},{4,5,6},{7,8,9}};
		
		/*****构造结果新二维数组用于存放转置结果*******/
		/*定义结果数组变量，注意 一定要先开辟一个内存，
		否则只是地址传递，也就是说两个数组名实际上指向的是同一块内存*/
		//而构造二维数组可以为维度来进行，不一定是一个矩阵，即每一行的长度不一定相同
		int result_arr[][]=new int[arr2D.length][];//先实现第一维
		for(int i=0 ; i<arr2D.length;i++){ //再实现第二维
			result_arr[i]=new int[arr2D[i].length];
		}
		
//		int result_arr[][]=Arrays.copyOf(arr2D, arr2D.length);
		//上面这个命令行行不通！
		/*****输出用于转置的二维数组*******/
		for (int x[]:arr2D){
        	for(int e:x){
        		System.out.print(e+" ");
        	}
        	System.out.println();
        }
		System.out.println();
		
        /*******进行元素倒置******/
        for(int i=0 ; i<arr2D.length;i++){
        	for(int j=0; j<arr2D[i].length;j++){
        		result_arr[j][i]=arr2D[i][j]; //转置核心
        	}	
        }
        
        /*****show the result in the result matrix*******/
        for (int x[]:result_arr){
        	for(int e:x){
        		System.out.print(e+" ");
        	}
        	System.out.println();
        }
        
	}


}
