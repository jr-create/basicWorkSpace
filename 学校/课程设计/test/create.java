package test;
import java.sql.*;
public class create {
	public static void main(String args[]){
		Connection con=null;
		String uri="jdbc:mysql://localhost:3306/students?useSSL=false&characterEncoding=utf-8";
//		localhostҲ����д��IP��ַ
		try{
			Class.forName("com.mysql.jdbc.Driver");//Class.forName�Ǽ�����������JDBC������������
		}catch(Exception e){}
		try{
			con=DriverManager.getConnection(uri,"root","ren@0072");
			System.out.println("���ӳɹ�");
		}
		catch(Exception ee){
			System.out.println("����ʧ��");
		}
	}
}
