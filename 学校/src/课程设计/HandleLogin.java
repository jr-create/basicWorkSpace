package �γ����;
import java.sql.*;
//��¼ģ��
import javax.swing.*;
import �γ����.Login;
public class HandleLogin {
	Connection con;
	PreparedStatement preSql;
	ResultSet rs;
	public HandleLogin(){
		con=JDBC.connect("students","root","ren@0072");
		if(con==null)System.out.println("Ϊ��");
		else{
			System.out.println("���ӳɹ�");
		}
	}
	public void queryVerify(Login loginModel){
		String id=loginModel.getID();
		String pw=loginModel.getPassword();
		String de=loginModel.getDepartment();
		String sqlStr ="select * from id where �û���=? and ����=? and ����=?";//��ѯ���ݿ��е�����
		try{
			preSql=con.prepareStatement(sqlStr);//����һ��PreparedStatement���󽫲�������SQL��䷢�͵����ݿ⡣
			preSql.setString(1, id);
			preSql.setString(2, pw);
			preSql.setString(3, de);
			rs=preSql.executeQuery();//�ڴ� PreparedStatement ������ִ�� SQL ��ѯ
			if(rs.next()){
				loginModel.setLoginSuccess(true);
				JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			}
			else{
				loginModel.setLoginSuccess(false);
				JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ����µ�¼");
			}
			preSql.close();
			rs.close();
			con.close();
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null, "���ִ���","����ʧ��",JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "���ִ���");
			e.printStackTrace();
		}
//		return loginModel;
	}
}
