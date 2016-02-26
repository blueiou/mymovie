package com.servlet;
import java.io.File; 
import java.io.IOException; 
import java.util.List; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import org.apache.commons.fileupload.FileItem; 
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload; 
import com.tools.MyDate;
public class UpLoad extends HttpServlet { 
@SuppressWarnings("unchecked") 
@Override 
protected void service(HttpServletRequest req, HttpServletResponse resp) 
throws ServletException, IOException { 
	//更换传来的文件的名称，采用的是当前的时间+随机生成的一个100以内的数字
	String rename=new MyDate().getYMDHMS()+MyDate.getRandomN();
req.setCharacterEncoding("utf-8"); 
resp.setContentType("text/html;charset=utf-8"); 
//为解析类提供配置信息 
DiskFileItemFactory factory = new DiskFileItemFactory(); 
//创建解析类的实例 
ServletFileUpload sfu = new ServletFileUpload(factory); 
//开始解析 
sfu.setFileSizeMax(1024*400); 
//每个表单域中数据会封装到一个对应的FileItem对象上 
try { 
List<FileItem> items = sfu.parseRequest(req); 
//区分表单域 
for (int i = 0; i < items.size(); i++) { 
FileItem item = items.get(i); 
//isFormField为true，表示这不是文件上传表单域 
if(!item.isFormField()){ 
ServletContext sctx = getServletContext(); 
//获得存放文件的物理路径 
//upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹 ,获取服务端下web项目的路径,具体到项目名称
String path = sctx.getRealPath("/images/movie"); 
System.out.println(path); 
//获得文件名 
String fileName = item.getName();
//使用小数点分割 需要转义字符 ,
String fileName2 = rename+"."+fileName.split("\\.")[1]; 
System.out.println("获得相对路径"+req.getRequestURI());
// String fileNameString=rename;
//该方法在某些平台(操作系统),会返回路径+文件名 
fileName2 = fileName2.substring(fileName2.lastIndexOf("/")+1); 
File file = new File(path+"\\"+fileName2); 
System.out.println("输出的file——"+file);
if(!file.exists()){ 
item.write(file);
//将上传图片的名字记录到数据库中 
resp.sendRedirect("error.jsp"); 
} 
} 
} 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
} 
