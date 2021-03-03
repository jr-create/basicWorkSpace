package MYSQL;

import java.sql.*;

public class creat {
    public static void main(String[] args) {
        Connection con = null;
        Statement sta = null;
        ResultSet rs;
        String SQL;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        try {
            String uri = "jdbc:mysql://localhost:3306/students?useSSL=false";
            con = DriverManager.getConnection(uri, "root", "ren@0072");  //连接数据库
            sta = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        try {
            SQL = "create table chengji(name varchar(40),score float)";
            sta.execute(SQL);//创建表执行SQL语句
        } catch (SQLException e) {
            System.out.println("该表已经存在");
        }
//      SQL ="insert into chengji values"+"('张三', 90),('李斯', 88),('刘二', 67)";
        try {
            sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//         sta.execute(SQL);
            rs = sta.executeQuery("select * from chengji "); // 查询表中的记录
            ResultSetMetaData meta = rs.getMetaData();
            String i = meta.getColumnName(1);
            System.out.println(i);
            rs.last();
            int i1 = rs.getRow();//游标指向当前行号
            rs.beforeFirst();//rs.First();是将游标移到第一行beforeFirst是移到之前
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
