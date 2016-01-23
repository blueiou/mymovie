package com.test;

import com.tools.Md5;

public class TestF {
	 public static void main(String[] args) {
	       /*String s = "0,1;3,6,4;7,1";
	       String[] a = s.split(";");
	       double[][] d;
	       d = new double[a.length][];
	       for(int i=0; i<a.length; i++){
	           String[] s_num = a[i].split(",");
	           for(int j=0; j<s_num.length; j++){
	               d[i] = new double[s_num.length];
	               d[i][j] = Double.parseDouble(s_num[j]);
	               System.out.println("d[" + i + "][" + j +"] = " + d[i][j]);
	                   }
	       }*/
		 
		 System.out.print(Md5.getMD5("PAjiyeon"));

	    }
}
