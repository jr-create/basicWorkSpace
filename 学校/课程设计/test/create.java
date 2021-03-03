package test;
import java.sql.*;
public class create {
	public static void main(String args[]){
		Connection con=null;
		String uri="jdbc:mysql://localhost:3306/students?useSSL=false&characterEncoding=utf-8";
//		localhost也可以写成IP地址
		try{
			Class.forName("com.mysql.jdbc.Driver");//Class.forName是加载驱动程序（JDBC驱动程序名）
		}catch(Exception e){}
		try{
			con=DriverManager.getConnection(uri,"root","ren@0072");
			System.out.println("连接成功");
		}
		catch(Exception ee){
			System.out.println("连接失败");
		}
	}
}
