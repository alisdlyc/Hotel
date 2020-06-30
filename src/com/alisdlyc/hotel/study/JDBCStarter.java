package com.alisdlyc.hotel.study;

import java.sql.*;

public class JDBCStarter {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1、 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2、 用户信息和url
        String url = "jdbc:mysql://localhost:3310/javaweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String password = "sd5.35365";

        // 3、 连接成功 返回数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4、 执行sql的statement对象
        Statement statement = connection.createStatement();

        // 5、 执行sql 查看返回结果
        String sql = "select * from usr";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("id") + " name: " + resultSet.getString("name") + " password: " + resultSet.getString("password"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
