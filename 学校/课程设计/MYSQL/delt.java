package MYSQL;
import java.sql.*;
public class delt {
   public static void main(String[] args) {
      Connection con =null;
      Statement sta = null;
      ResultSet rs;
      String SQL;
      try { 
        Class.forName("com.mysql.jdbc.Driver");//加载驱动
      }
      catch(Exception e) {
        System.out.println(e);  
        return;
      }
      try { 
         String uri ="jdbc:mysql://localhost:3306/students?useSSL=false";
         con=DriverManager.getConnection(uri,"root","ren@0072");  //连接数据库
         sta = con.createStatement();
      }
      catch(Exception e) {
        System.out.println(e);  
        return;
      }
     // SQL ="delete from chengji "+"where name='张三'";//删除语句
      SQL="update chengji set name='jfsas'where name='张三'";//修改语句
      try {
         sta.execute(SQL);
         rs = sta.executeQuery("select * from id "); // 查询表中的记录
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
