package �γ����;
import java.sql.*;

import javax.swing.*;

import �γ����.Register;
import �γ����.JDBC;
//ע�ᴦ���ߴ���
public class HandleInsertData {
	Connection con;
	PreparedStatement preSql;
	public HandleInsertData(){
		con=JDBC.connect("students","root","ren@0072");
		if(con==null)System.out.println("Ϊ��");
		else{
			System.out.println("����ɹ�");
		}
	}
	public void writeRegisterModel(Register register){
		int ok =0;
		try{
			// Ҫִ�е�SQL���
			String sql = "insert into id values(?,?,?,?,?)";//���ݿ��������
			preSql=con.prepareStatement(sql);//����һ��PreparedStatement�������ڽ���������SQL��䷢�͵����ݿ⡣ 
			System.out.println("-------------------------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-------------------------------");
			System.out.println("�û���" + "\t" + "����" + "\t" + "�绰"+ "\t" + "����"+ "\t" + "����");
			System.out.println("-------------------------------");
			// ��ȡ��ID����������
			preSql.setString(1, register.getID());
			// ��ȡ�����롯��������
			preSql.setString(2, register.getPassword());
			// ��ȡ���绰�����ţ����ڡ���������
			preSql.setString(3, register.gettelephone());
			preSql.setString(4, register.getdepartment());
			preSql.setString(5, register.getBirth());
			// �ж��Ƿ����
			ok=preSql.executeUpdate();
			System.out.println(ok);
			preSql.close();
			con.close();
		}catch(Exception ee){
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null, "id�����ظ���","����", JOptionPane.WARNING_MESSAGE);
		}finally {
			System.out.println("-------------------------------");
			System.out.println("���ݿ����ݲ���ɹ���");
		}
		if(ok!=0){
			JOptionPane.showMessageDialog(null, "ע��ɹ���","��ϲ", JOptionPane.WARNING_MESSAGE);
		}
	}
}
