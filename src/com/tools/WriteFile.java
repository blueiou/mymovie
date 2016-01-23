package com.tools;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {

	//更新TXT
	public static void bufferRead(String path,String con) {
		  String str = new String(); //原有txt内容  
	        String s1 = new String();//内容更新  
	        try {  
	File f=new File(path);
		if (!f.exists()) {
			System.out.print("文件不存在");
			return;
		}
		else {
			f.createNewFile();
			
		}
		
		 BufferedReader input = new BufferedReader(new FileReader(f));  
		  
         while ((str = input.readLine()) != null) {  
             s1 += str + "\n";  
         }  
         System.out.println(s1);  
         input.close();  
         s1 += con;  

         BufferedWriter output = new BufferedWriter(new FileWriter(f));  
         output.write(s1); 
         
         output.close();  
     } 
	catch (Exception e) {  
         e.printStackTrace();  

     }  
  
	}	
	//追加
	public static void fileOutputStream(String temp) throws IOException{
		
		
		//String temp="Hello world!\n";  
		 
        FileOutputStream fos = new FileOutputStream("d:\\UserInfo.txt",true);//true表示在文件末尾追加  
 
        fos.write(temp.getBytes());  
 
        fos.close();//流要及时关闭  
	}
	
	public static void writeFile(String con){
		File file=new File("D://UserInfo.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bWriter=new BufferedWriter(fileWriter);
			bWriter.write(con);
			//bWriter.write("\r\n");
			bWriter.close();
			System.out.print("BufferedWriter写入成功");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	}


