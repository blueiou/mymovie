package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestStringTwo {
	public static List<String> splitString(String str,int length){
		List<String> ret=new ArrayList<String>();
		if(length>=str.length()){
		ret.add(str);
		}else{
		//如何填写这段代码?
			while(length<str.length())
			{
			ret.add(str.substring(0,length));
			str = str.substring(length,str.length());
			}
			ret.add(str);
			
		}
		return ret;

		}
	public static void main(String args[]){
		
		List dataList=splitString("11111112222222222111121112121211212121212121212221121111121211111", 6);
		String temp="";
		for(int i=0;i<dataList.size();i++){
			
			//System.out.print("{"+dataList.get(i)+"},");
			
			temp=temp+"{"+dataList.get(i)+"},";
		}
		 String[] one = temp.split(",");
	
		 
		 
		/*int a[][]={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int b[][]=new int[3][4];//前面为长度6
		int i,j;
		System.out.println("数组a各元素的值为：");
		for(i=0;i<4;i++){
		for(j=0;j<3;j++)
		System.out.print(a[i][j]+"\t");
		System.out.println();
		}
		for(i=0;i<4;i++)
		for(j=0;j<3;j++)
		b[j][i]=a[i][j];	//转置
		System.out.println("数组b各元素的值为：");
		for(i=0;i<3;i++){
		for(j=0;j<4;j++)
		System.out.print(b[i][j]+" ");
		System.out.println();
		}*/
		}
		
}
