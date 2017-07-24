/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oe.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author user1
 */
public class DatabaseConnection {
    
    private static final Logger LOGGER = Logger.getLogger(Connection.class.getName());
    
    public static Connection getConnection() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://LocalHost:3306/test","root","1234");
        } catch(ClassNotFoundException | SQLException e) {
            LOGGER.severe("");
        }
        return null;
    }
    
    public static void closeConnection(Connection con)  {
        if(con != null) {
            try {
            con.close();
            } catch(SQLException e) {
                LOGGER.severe("Error while closing DB connection.");
            }
        }
    }

    
}
