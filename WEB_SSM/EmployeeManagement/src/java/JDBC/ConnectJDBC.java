/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ngoct
 */
public class ConnectJDBC {

    public static Connection connect;

    public static Connection getConnect() throws ClassNotFoundException, SQLException {
        if (connect == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=Employee;trustServerCertificate=true";
                String username = "sa";
                String pass = "12345";

                Connection connectDriver = DriverManager.getConnection(url, username, pass);
                connect = connectDriver;
            } catch (SQLException ex) {
                throw new SQLException("Can't connect DB");
            }
        }
        return connect;
    }
}
