package MYSQL;

import java.sql.*;

public class creat {
    public static void main(String[] args) {
        Connection con = null;
        Statement sta = null;
        ResultSet rs;
        String SQL;
        try {
            Class.forName("com.mysql.jdbc.Driver");//��������
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        try {
            String uri = "jdbc:mysql://localhost:3306/students?useSSL=false";
            con = DriverManager.getConnection(uri, "root", "ren@0072");  //�������ݿ�
            sta = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        try {
            SQL = "create table chengji(name varchar(40),score float)";
            sta.execute(SQL);//������ִ��SQL���
        } catch (SQLException e) {
            System.out.println("�ñ��Ѿ�����");
        }
//      SQL ="insert into chengji values"+"('����', 90),('��˹', 88),('����', 67)";
        try {
            sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//         sta.execute(SQL);
            rs = sta.executeQuery("select * from chengji "); // ��ѯ���еļ�¼
            ResultSetMetaData meta = rs.getMetaData();
            String i = meta.getColumnName(1);
            System.out.println(i);
            rs.last();
            int i1 = rs.getRow();//�α�ָ��ǰ�к�
            rs.beforeFirst();//rs.First();�ǽ��α��Ƶ���һ��beforeFirst���Ƶ�֮ǰ
            System.out.println(i1);
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.print(name + "\t");
                float score = rs.getFloat(2);
                System.out.println(score);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
