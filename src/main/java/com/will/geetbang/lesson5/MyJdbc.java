package com.will.geetbang.lesson5;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/3 10:11 PM
 */
public class MyJdbc {

    public static void main(String[] args) {
        try {
            // 加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }

        String url = "jdbc:mysql://192.168.10.211:13307/datapan_pn";
        String username = "root";
        String password = "12345678";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername(username);
        config.setPassword(password);
        HikariDataSource dataSource = new HikariDataSource(config);

//        try(Connection con = DriverManager.getConnection(url , username , password);){
        try(Connection con = dataSource.getConnection();){
            con.setAutoCommit(false);
            PreparedStatement preparedStatement = con.prepareStatement("insert into mobile_map values (3,'abcdef','13012345678')");
            preparedStatement.executeUpdate();

            preparedStatement = con.prepareStatement("select * from mobile_map where id=3");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+":"+resultSet.getString("pn_md5")+":"+resultSet.getString("pn")+"\n");
            }

            preparedStatement = con.prepareStatement("update mobile_map set pn='18012345678' where id=3");
            preparedStatement.executeUpdate();

            preparedStatement = con.prepareStatement("select * from mobile_map where id=3");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+":"+resultSet.getString("pn_md5")+":"+resultSet.getString("pn")+"\n");
            }

            preparedStatement = con.prepareStatement("delete from mobile_map where id=3");
            preparedStatement.executeUpdate();

            con.commit();
        } catch(SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }
    }

}
