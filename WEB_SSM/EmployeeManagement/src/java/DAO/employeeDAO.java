/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.employeeDTO;
import DTO.positionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class employeeDAO {

    public static employeeDAO instance;

    public static employeeDAO getInstance() {
        if (instance == null) {
            instance = new employeeDAO();
        }
        return instance;
    }

    public List<employeeDTO> getEmployees() throws ClassNotFoundException, SQLException {
        List<employeeDTO> data = new ArrayList<>();
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM \n"
                + "employee AS E\n"
                + "INNER JOIN position AS P \n"
                + "ON E.position_id = P.position_id;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            employeeDTO employee = new employeeDTO(rs.getInt("employee_id"),
                    rs.getString("employee_name"),
                    rs.getString("position_id"),
                    rs.getString("phone"),
                    rs.getString("mail"),
                    rs.getLong("salary")
            );
            data.add(employee);
        }
        return data;
    }

    public List<positionDTO> getPosition() throws ClassNotFoundException, SQLException {
        List<positionDTO> positions = new ArrayList<>();
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM position");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            positionDTO position = new positionDTO(rs.getString("position_id"),
                    rs.getString("position_name"));
            positions.add(position);
        }
        return positions;
    }

    public void addEmployee(employeeDTO employee) throws SQLException, ClassNotFoundException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("INSERT INTO employee(employee_name, position_id, phone, mail) VALUES (?, ?, ?, ?)");
        ps.setString(1, employee.getEmployeeName());
        ps.setString(2, employee.getPositionID());
        ps.setString(3, employee.getPhone());
        ps.setString(4, employee.getMail());
        ps.execute();
    }

    public void updateEmployee(employeeDTO employee) throws SQLException, ClassNotFoundException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("UPDATE employee SET employee_name = ?, position_id = ?, "
                + "phone = ?, mail = ? WHERE employee_id = ?");
        ps.setString(1, employee.getEmployeeName());
        ps.setString(2, employee.getPositionID());
        ps.setString(3, employee.getPhone());
        ps.setString(4, employee.getMail());
        ps.setInt(5, employee.getEmployeeID());
        ps.execute();
    }

    public void deleteEmployee(Integer employeeID) throws SQLException, ClassNotFoundException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("DELETE FROM employee WHERE employee_id = ?");
        ps.setInt(1, employeeID);
        ps.execute();
    }
}
