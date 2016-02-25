package com.test;

public class TestString {

	final static double PI=3.1415;
	public static void main(String[] args) {
		
		String a="['I6','I7','I8']";
		
		
		String bStrings=a.substring(2,a.length()-2);
		String[] cStrings=bStrings.split("\',\'");
		System.out.println(bStrings);
		for (String string : cStrings) {
			System.out.println(string);
		}
		/*StaticTest st1=new StaticTest();
    	StaticTest st2=new StaticTest();
    	st1.method2("HAN");
		
		*//*****����Ҫ����ת�õĶ�ά����*******//*
		int arr2D[][]={{1,2,3},{4,5,6},{7,8,9}};
		
		*//*****�������¶�ά�������ڴ��ת�ý��*******//*
		���������������ע�� һ��Ҫ�ȿ���һ���ڴ棬
		����ֻ�ǵ�ַ���ݣ�Ҳ����˵����������ʵ����ָ�����ͬһ���ڴ�
		//�����ά�������Ϊά�������У���һ����һ�����󣬼�ÿһ�еĳ��Ȳ�һ����ͬ
		int result_arr[][]=new int[arr2D.length][];//��ʵ�ֵ�һά
		for(int i=0 ; i<arr2D.length;i++){ //��ʵ�ֵڶ�ά
			result_arr[i]=new int[arr2D[i].length];
		}
		
//		int result_arr[][]=Arrays.copyOf(arr2D, arr2D.length);
		//��������������в�ͨ��
		*//*****�������ת�õĶ�ά����*******//*
		for (int x[]:arr2D){
        	for(int e:x){
        		System.out.print(e+" ");
        	}
        	System.out.println();
        }
		System.out.println();
		
        *//*******����Ԫ�ص���******//*
        for(int i=0 ; i<arr2D.length;i++){
        	for(int j=0; j<arr2D[i].length;j++){
        		result_arr[j][i]=arr2D[i][j]; //ת�ú���
        	}	
        }
        
        *//*****show the result in the result matrix*******//*
        for (int x[]:result_arr){
        	for(int e:x){
        		System.out.print(e+" ");
        	}
        	System.out.println();
        }
        */
	}


}
