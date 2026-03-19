
package com.mycompany.gerenciador.ordens.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GConnection {
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        String URL = "jdbc:mysql://localhost:3306/gerenciadorordem";
        String USER = "root";
        String PASSWORD = "root";
        
        return con = DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
