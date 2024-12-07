/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class ConnectJDBC {

    public static Connection connect;

    public static Connection getConnect() throws SQLException, ClassNotFoundException {
        if (connect == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //thông báo thư viện sử dụng
                String url = "jdbc:sqlserver://localhost:1433;databaseName=product;trustServerCertificate=true";
                String userName = "sa";
                String password = "12345";

                Connection connectDriver = DriverManager.getConnection(url, userName, password);
                ConnectJDBC.connect = connectDriver;
            } catch (SQLException ex) {
                Logger.getGlobal().log(Level.SEVERE, ex.getMessage(), ex);
                throw new SQLException("Can't connect DB");
            }
        }

        return connect;

    }

}
