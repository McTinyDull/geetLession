package com.will.geetbang.lesson6;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/17 8:27 PM
 */
public class BatchInsert {
    public static void main(String[] args) {
        try {
            // 加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true";
        String username = "root";
        String password = "";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername(username);
        config.setPassword(password);
        HikariDataSource dataSource = new HikariDataSource(config);
        long startTime = System.currentTimeMillis();
        try(Connection con = dataSource.getConnection();) {
            con.setAutoCommit(false);

            String sql = "insert into t_batch_insert(id) values(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 1; i <= 1000000; i++) {
                ps.setObject(1,i);
                ps.addBatch();
                if(i%1000 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                    con.commit();
                }
            }
            System.out.printf("total time:%d%n",System.currentTimeMillis()-startTime);
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        //batch_size:1000,url:jdbc:mysql://localhost:3306/test,time:105074ms
        //batch_size:1000,url:jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true,time:5901ms
    }
}
