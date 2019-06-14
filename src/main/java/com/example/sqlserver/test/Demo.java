package com.example.sqlserver.test;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
         //update();

        PreparedStatement ps = null;
        Connection ct = null;
        ResultSet rs = null;
        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.得到链接 127.0.0.1:1433
            ct = DriverManager.getConnection
                    ("jdbc:sqlserver://192.168.100.109:1433;databasename=test", "sa", "Jin5221318");

            ps = ct.prepareStatement("select * from user_test");
            rs = ps.executeQuery();
            while (rs.next()) {
                String cno = rs.getString(1);
                String cname = rs.getString(2);
                String tno = rs.getString(3);

                System.out.println("cno " + cno + " cname " + cname + " tno " + tno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (ct != null) ct.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void update() {
        Connection connection = null;
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
        String dbURL = "jdbc:sqlserver://192.168.100.109:1433;DatabaseName=test";//数据源  ！！！注意若出现加载或者连接数据库失败一般是这里出现问题
        String Name = "sa";
        String Pwd = "Jin5221318";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbURL, Name, Pwd);
            System.out.println("连接数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //增删改操作
        String sql_1 = "insert into user_test values('1','王五','1','1193')";
        int count_1 = 0;
        try {
            count_1 = stmt.executeUpdate(sql_1);
            System.out.println("dsa");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//返回值表示增删改几条数据
        //处理结果
        if (count_1 > 0) {
            System.out.println("更新成功!");
        }
        //查询操作
        String sql_2 = "select * from test";

        //关闭
        try {
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
