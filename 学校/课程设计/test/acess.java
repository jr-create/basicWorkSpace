package test;

import java.sql.*;
import java.util.Properties;

public class acess {
	String SQL;
	Connection con;
	Statement st;
	ResultSet rs;
	public acess(){
		String url = null;
		try {
			//url="jdbc:odbc:driver{Microsoft Access Driver(*.mdb,*.accdb)};DBQ=D:\\ACESS\\123.accdb";//db是数据源名称
			url="jdbc:odbc:db";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			Properties prop = new Properties();    //gb字符集
			prop.put("charSet", "gb2312");    
			con = DriverManager.getConnection(url,prop);System.out.println(con);
			st = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}//
		try { 
			SQL = "create table chengji(name varchar(40),score float)";
			st.execute(SQL);//创建表执行SQL语句
		}
		catch(SQLException e) { 
			System.out.println("该表已经存在"); 
		}
		//	      SQL ="delete from chengji where name='jfsas'";//删除数据
		//		SQL="update chengji set name='jfsas'where name='张三'";//修改语句
		SQL ="Insert INTO chengji(name,score)"
				+ "Select DISTINCTROW * FROM (Select '天鸣0' AS name,12 AS score  FROM chengji UNION "
				+ "Select '天鸣' AS name,12 AS score FROM chengji)";//插入数据

		//		SQL="drop table 123 ";//删除数据表
		try {
			st.execute(SQL);
			System.out.println("删除成功");
			rs = st.executeQuery("select * from chengji "); // 查询表中的记录
			while(rs.next()) {
				String name=rs.getString(1);
				System.out.print(name+"\t");
				float score=rs.getFloat(2);
				System.out.println(score);
			}
			con.close();
		} 
		catch(SQLException e) {System.out.println(e);}
	}
		public static void main(String args[]){
			acess a=new acess();
		}
}
