package test;
import java.sql.*;

public class test1 {
	public static void main(String[] args) {

		Connection conn = null;
		// ��ȡ���ӵ�һ��״̬
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// getConnection()����������MySQL���ݿ⣡characterEncoding=utf-8���ַ�����
			conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/students?useUnicode=true&characterEncoding=utf-8&useSSL=false",
							"root", "ren@0072");
			if (!conn.isClosed())
				System.out.println("���ݿ����ӳɹ���");
			// ����statement���������ִ��SQL��䣡
			Statement Statement = conn.createStatement();
			// Ҫִ�е�SQL���
			String sql = "select * from mess";//
			// ResultSet�࣬������Ż�ȡ�Ľ������
			ResultSet rs = Statement.executeQuery(sql);
			System.out.println("-------------------------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-------------------------------");
			System.out.println("ѧ��" + "\t" + "����" + "\t" + "��ѧ�ɼ�" + "\t"
					+ "���ĳɼ�"+"\t\t"+"�绰"+"\t"+"����");
			System.out.println("-------------------------------");
			String id = null;
			String name = null;
			String age = null;
			String sex = null;
			String pos=null;
			String mon=null;
			while (rs.next()) {
				// ��ȡ��ѧ�š���������
				id = rs.getString("���");
				// ��ȡ����������������
				name = rs.getString("����");
				// ��ȡ����ѧ�ɼ�����������
				age = rs.getString("����");
				// ��ȡ�����ĳɼ�����������
				sex = rs.getString("�Ա�");
				pos=rs.getString("�绰");
				mon=rs.getString("����");
				// ������
				System.out.println(id + "\t" + name + "\t" + age + "\t"
						+ sex+"\t"+pos+"\t"+mon);
			}
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// ���ݿ��������쳣����
			System.out.println("���ݿ���������ʧ�ܣ�");
			e.printStackTrace();
		} catch (SQLException e1) {
			// ���ݿ�����ʧ���쳣����
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			System.out.println("-------------------------------");
			System.out.println("���ݿ����ݻ�ȡ�ɹ���");
		}
	}
}
