package com.test;

public class TestStringThree {
	
public static void main(String args[]){
/*	String str="11111622222622221111211121212121212121212121212221121111121211111" ;
	String temp="";
	for( int i = 0 ; i < str.length() ; i++ ){
	  //  System.out.print( str.charAt( i )+" ;" );
	    temp=temp+str.charAt( i )+";";
	}
	String datasString=temp.substring(0,str.length()-1);
	char[] mychar = new char[] { 
			'2', '2', '2', '2', '1', '1', '1', '1','1', '1','2', '2', '2', '2', '1', '1', '1', '1','1', '1','2', '2', '2', '2', '1', '1', '1', '1',
			'1', '1','2', '2', '2', '2', '1', '1', '1', '1',
						'1', '1','2', '2', '2', '2', '1', '1', '1','6','7','2', '1', '1', '1','6','8','2', '1', '1', '1','6','9'};
				for (char c : mychar) {
					//System.out.print(c);
				}
				System.out.println();
				//System.out.println(mychar.length);
				int n = 4;
				char[][] newchar = new char[10][6];
				char[][] newchar2 = new char[6][10];
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 6; j++) {
						if ((i * 6 + j) >= mychar.length) {
							break;
						} else {
							newchar[i][j] = mychar[i * 6 + j];
						}
					}
				}
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 6; j++) {
						System.out.print(newchar[i][j]);
					}
					System.out.println();
				}
				System.out.println();
				for (int i = 0; i < newchar.length; i++) {
					for (int j = 0; j < newchar[i].length; j++) {
						newchar2[j][i] = newchar[i][j]; // 转置核心
					//System.out.print(newchar2[j][i]);
					}
				}
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 10; j++) {
						System.out.print(newchar2[i][j]);
					}
					System.out.println();
				}*/
	String s1="12121211111212121";
	
	char [] temp=s1.toCharArray();	
	for (char c : temp) {
		//System.out.print(c);
	}
	System.out.println("长度"+temp.length);
	int n = 4;
	char[][] newchar = new char[10][6];
	char[][] newchar2 = new char[6][10];
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 6; j++) {
			if ((i * 6 + j) >= temp.length) {
				break;
			} else {
				newchar[i][j] = temp[i * 6 + j];
			}
		}
	}
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 6; j++) {
			//System.out.print(newchar[i][j]+"\t");
		}
		//System.out.println();
	}
	//System.out.println();
	for (int i = 0; i < newchar.length; i++) {
		for (int j = 0; j < newchar[i].length; j++) {
			newchar2[j][i] = newchar[i][j]; // 转置核心
		}
	}
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 10; j++) {
			System.out.print(newchar2[i][j]);
		}
		System.out.println();
	}
	/***************分隔线**************/
/*	char[] mychar = new char[] { '2', '2', '2', '2', '1', '1', '1', '1','1', '1','2', '2', '2', '2', '1', '1', '1', '1','1', '1','2', '2', '2', '2', '1', '1', '1', '1',
'1', '1','2', '2', '2', '2', '1', '1', '1', '1',
			'1', '1','2', '2', '2', '2', '1', '1', '1','6','7','2', '1', '1', '1','6','8','2', '1', '1', '1','6','9'};
	for (char c : mychar) {
		System.out.print(c);
	}
	//System.out.println();
	System.out.println(mychar.length);
	int n = 4;
	char[][] newchar = new char[10][6];
	char[][] newchar2 = new char[6][10];
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 6; j++) {
			if ((i * 6 + j) >= mychar.length) {
				break;
			} else {
				newchar[i][j] = mychar[i * 6 + j];
			}
		}
	}
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 6; j++) {
			//System.out.print(newchar[i][j]+"\t");
		}
		//System.out.println();
	}
	//System.out.println();
	for (int i = 0; i < newchar.length; i++) {
		for (int j = 0; j < newchar[i].length; j++) {
			newchar2[j][i] = newchar[i][j]; // 转置核心
		}
	}
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 10; j++) {
			System.out.print(newchar2[i][j]);
		}
		System.out.println();
	}
	
*/	
	
}
	
}

