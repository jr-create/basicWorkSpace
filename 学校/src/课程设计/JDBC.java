package �γ����;
import java.sql.*;
public class JDBC {
	public static Connection connect(String JDName,String id,String password){
		Connection con=null;
		String uri="jdbc:mysql://localhost:3306/"+JDName+"?useSSL=false&characterEncoding=utf-8";
//		localhostҲ����д��IP��ַ
		try{
			Class.forName("com.mysql.jdbc.Driver");//Class.forName�Ǽ�����������JDBC������������
		}catch(Exception e){}
		try{
			con=DriverManager.getConnection(uri,id,password);
			System.out.println("���ӳɹ�");
		}
		catch(Exception ee){
			System.out.println("����ʧ��");
		}
		return con;
	}
}
