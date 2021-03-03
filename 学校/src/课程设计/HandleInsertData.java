package 课程设计;
import java.sql.*;

import javax.swing.*;

import 课程设计.Register;
import 课程设计.JDBC;
//注册处理者代码
public class HandleInsertData {
	Connection con;
	PreparedStatement preSql;
	public HandleInsertData(){
		con=JDBC.connect("students","root","ren@0072");
		if(con==null)System.out.println("为空");
		else{
			System.out.println("进入成功");
		}
	}
	public void writeRegisterModel(Register register){
		int ok =0;
		try{
			// 要执行的SQL语句
			String sql = "insert into id values(?,?,?,?,?)";//数据库插入数据
			preSql=con.prepareStatement(sql);//创建一个PreparedStatement对象，用于将参数化的SQL语句发送到数据库。 
			System.out.println("-------------------------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-------------------------------");
			System.out.println("用户名" + "\t" + "密码" + "\t" + "电话"+ "\t" + "部门"+ "\t" + "日期");
			System.out.println("-------------------------------");
			// 获取‘ID’这列数据
			preSql.setString(1, register.getID());
			// 获取‘密码’这列数据
			preSql.setString(2, register.getPassword());
			// 获取‘电话，部门，日期’这列数据
			preSql.setString(3, register.gettelephone());
			preSql.setString(4, register.getdepartment());
			preSql.setString(5, register.getBirth());
			// 判断是否完成
			ok=preSql.executeUpdate();
			System.out.println(ok);
			preSql.close();
			con.close();
		}catch(Exception ee){
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null, "id不能重复！","警告", JOptionPane.WARNING_MESSAGE);
		}finally {
			System.out.println("-------------------------------");
			System.out.println("数据库数据插入成功！");
		}
		if(ok!=0){
			JOptionPane.showMessageDialog(null, "注册成功！","恭喜", JOptionPane.WARNING_MESSAGE);
		}
	}
}
