package test;
import java.sql.*;

public class test1 {
	public static void main(String[] args) {

		Connection conn = null;
		// 获取连接的一个状态
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// getConnection()方法，连接MySQL数据库！characterEncoding=utf-8是字符编码
			conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/students?useUnicode=true&characterEncoding=utf-8&useSSL=false",
							"root", "ren@0072");
			if (!conn.isClosed())
				System.out.println("数据库连接成功！");
			// 创建statement类对象，用来执行SQL语句！
			Statement Statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "select * from mess";//
			// ResultSet类，用来存放获取的结果集！
			ResultSet rs = Statement.executeQuery(sql);
			System.out.println("-------------------------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-------------------------------");
			System.out.println("学号" + "\t" + "姓名" + "\t" + "数学成绩" + "\t"
					+ "语文成绩"+"\t\t"+"电话"+"\t"+"工资");
			System.out.println("-------------------------------");
			String id = null;
			String name = null;
			String age = null;
			String sex = null;
			String pos=null;
			String mon=null;
			while (rs.next()) {
				// 获取‘学号’这列数据
				id = rs.getString("编号");
				// 获取‘姓名’这列数据
				name = rs.getString("姓名");
				// 获取‘数学成绩’这列数据
				age = rs.getString("年龄");
				// 获取‘语文成绩’这列数据
				sex = rs.getString("性别");
				pos=rs.getString("电话");
				mon=rs.getString("工资");
				// 输出结果
				System.out.println(id + "\t" + name + "\t" + age + "\t"
						+ sex+"\t"+pos+"\t"+mon);
			}
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("数据库驱动加载失败！");
			e.printStackTrace();
		} catch (SQLException e1) {
			// 数据库连接失败异常处理
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			System.out.println("-------------------------------");
			System.out.println("数据库数据获取成功！");
		}
	}
}
