package 课程设计;
import java.sql.*;
//登录模型
import javax.swing.*;
import 课程设计.Login;
public class HandleLogin {
	Connection con;
	PreparedStatement preSql;
	ResultSet rs;
	public HandleLogin(){
		con=JDBC.connect("students","root","ren@0072");
		if(con==null)System.out.println("为空");
		else{
			System.out.println("连接成功");
		}
	}
	public void queryVerify(Login loginModel){
		String id=loginModel.getID();
		String pw=loginModel.getPassword();
		String de=loginModel.getDepartment();
		String sqlStr ="select * from id where 用户名=? and 密码=? and 部门=?";//查询数据库中的数据
		try{
			preSql=con.prepareStatement(sqlStr);//创建一个PreparedStatement对象将参数化的SQL语句发送到数据库。
			preSql.setString(1, id);
			preSql.setString(2, pw);
			preSql.setString(3, de);
			rs=preSql.executeQuery();//在此 PreparedStatement 对象中执行 SQL 查询
			if(rs.next()){
				loginModel.setLoginSuccess(true);
				JOptionPane.showMessageDialog(null, "登录成功");
			}
			else{
				loginModel.setLoginSuccess(false);
				JOptionPane.showMessageDialog(null, "登录失败，重新登录");
			}
			preSql.close();
			rs.close();
			con.close();
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null, "出现错误","加入失败",JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "出现错误");
			e.printStackTrace();
		}
//		return loginModel;
	}
}
