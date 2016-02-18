package com.test;

import java.util.Random;

import com.entity.Play;
import com.mysql.fabric.xmlrpc.base.Data;
import com.tools.CacheClass;
import com.tools.Md5;
import com.tools.MyDate;

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
		 String fileName = "122.png";
		 String fileName2 = "2018"+fileName.split("\\.")[0]; 
		 System.out.print(new Play().getGoods().getGood_id());

	    }
}
