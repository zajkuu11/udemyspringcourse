package com.zajkuu.udemyspringcourse.oneToOneMapping.jdbc;

import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.Instructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static void main(String[] args) {

        String JdbcUrl = "jdbc:mariadb://localhost:3306/hb-01-one-to-one-uni?autoReconnect=true&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(JdbcUrl, user, pass);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();

    }
}
