package test;
import java.sql.*;

public class jdbc {
    Connection connection;
    public Connection getConnection(){
        try {
//        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
//        	Class.forName("com.microsoft.sqlserver..jdbc.SQLServerDriver")
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useUnicode=true&characterEncoding=utf-8&useSSL=false","root", "ren@0072");
            System.out.println("连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
        
    }

    public static void main(String[] args) {
        jdbc test2=new jdbc();
        test2.getConnection();
    }
    
}

