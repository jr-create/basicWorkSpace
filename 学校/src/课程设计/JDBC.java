package 课程设计;
import java.sql.*;
public class JDBC {
	public static Connection connect(String JDName,String id,String password){
		Connection con=null;
		String uri="jdbc:mysql://localhost:3306/"+JDName+"?useSSL=false&characterEncoding=utf-8";
//		localhost也可以写成IP地址
		try{
			Class.forName("com.mysql.jdbc.Driver");//Class.forName是加载驱动程序（JDBC驱动程序名）
		}catch(Exception e){}
		try{
			con=DriverManager.getConnection(uri,id,password);
			System.out.println("连接成功");
		}
		catch(Exception ee){
			System.out.println("连接失败");
		}
		return con;
	}
}
