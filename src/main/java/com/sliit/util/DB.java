package com.sliit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        /*
         * This create new connection objects when connection is closed or it is
         * null
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        }


        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "root");

        } catch (SQLException e) {
            System.out.println("SQLException occurred!");
            e.printStackTrace();
        }

        if (connection == null) {
            System.out.println("connection object null!");
        }
        return connection;
    }
}
