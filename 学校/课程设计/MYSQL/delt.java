package MYSQL;
import java.sql.*;
public class delt {
   public static void main(String[] args) {
      Connection con =null;
      Statement sta = null;
      ResultSet rs;
      String SQL;
      try { 
        Class.forName("com.mysql.jdbc.Driver");//��������
      }
      catch(Exception e) {
        System.out.println(e);  
        return;
      }
      try { 
         String uri ="jdbc:mysql://localhost:3306/students?useSSL=false";
         con=DriverManager.getConnection(uri,"root","ren@0072");  //�������ݿ�
         sta = con.createStatement();
      }
      catch(Exception e) {
        System.out.println(e);  
        return;
      }
     // SQL ="delete from chengji "+"where name='����'";//ɾ�����
      SQL="update chengji set name='jfsas'where name='����'";//�޸����
      try {
         sta.execute(SQL);
         rs = sta.executeQuery("select * from id "); // ��ѯ���еļ�¼
         while(rs.next()) {
            String name=rs.getString(1);
            System.out.print(name+"\t");
            float score=rs.getFloat(2);
            System.out.println(score);
         }
         con.close();
      } 
      catch(SQLException e) {
          System.out.println(e);  
      }
  }
}
