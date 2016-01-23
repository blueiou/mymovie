package com.tools;

public class Replace {

	public static void main(String[] args) {
		  // TODO Auto-generated method stub
		 }
		 public static String replace(String strSource,String strFrom,String strTo){ 
		  String strDest = ""; 
		  int intFromLen = strFrom.length(); 
		  int intPos;
		  while((intPos=strSource.indexOf(strFrom))!=-1){ 
		  strDest = strDest + strSource.substring(0,intPos); 
		  strDest = strDest + strTo; 
		  strSource = strSource.substring(intPos+intFromLen); 
		  } 
		  strDest = strDest + strSource;
		  return strDest; 
		  }
	
	
}
