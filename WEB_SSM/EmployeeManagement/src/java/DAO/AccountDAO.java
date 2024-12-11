/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ngoct
 */
public class AccountDAO {

    public static AccountDAO instance;

    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    public AccountDTO getAccount(AccountDTO account) throws ClassNotFoundException, SQLException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM account WHERE username = ? "
                + "AND pass = ?");
        ps.setString(1, account.getAccountName());
        ps.setString(2, account.getAccountPass());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new AccountDTO(rs.getInt("account_id"), rs.getString("username"), rs.getString("pass"));
        }
        return null;
    }

    public void createAccount(String username, String pass) throws SQLException, ClassNotFoundException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("INSERT INTO account(username, pass) VALUES (?, ?)");
        ps.setString(1, username);
        ps.setString(2, pass);
        ps.execute();
    }

}
