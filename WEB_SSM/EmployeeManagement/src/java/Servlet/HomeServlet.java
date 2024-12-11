/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.employeeDAO;
import DTO.employeeDTO;
import DTO.positionDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngoct
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        employeeDAO DAO = employeeDAO.getInstance();
        try {
            List<employeeDTO> employees = DAO.getEmployees();
            req.setAttribute("employees", employees);

            List<positionDTO> positions = DAO.getPosition();
            req.setAttribute("positions", positions);

        } catch (ClassNotFoundException | SQLException ex) {
            req.setAttribute("error", ex.getMessage());
        }

        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        try {
            employeeDAO DAO = employeeDAO.getInstance();
            String func = req.getParameter("func");
            switch (func) {
                case "add":
                    handleAdd(req, resp);
                    break;

                case "update":
                    handleUpdate(req, resp);
                    break;

                case "delete":
                    handleDelete(req, resp);
                    break;

                default:
                    throw new ServletException("Not found function");
            }
        } catch (ServletException | IOException ex) {
            req.setAttribute("error", ex.getMessage());
        }
    }

    public void handleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String employeeName = req.getParameter("name");
            String positionID = req.getParameter("position");
            String gmail = req.getParameter("mail");
            String phone = req.getParameter("phone");
            employeeDAO DAO = employeeDAO.getInstance();

            if (phone.matches("\\d{10,12}")) {
                employeeDTO employee = new employeeDTO(null, employeeName, positionID, phone, gmail, null);
                DAO.addEmployee(employee);
            } else {
                req.setAttribute("error", "Wrong phone format");
            }
            List<employeeDTO> employees = DAO.getEmployees();
            req.setAttribute("employees", employees);

            List<positionDTO> positions = DAO.getPosition();
            req.setAttribute("positions", positions);
        } catch (SQLException | ClassNotFoundException ex) {
            req.setAttribute("eror", ex.getMessage());
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    public void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String employeeName = req.getParameter("name");
            String positionID = req.getParameter("position");
            String gmail = req.getParameter("mail");
            String phone = req.getParameter("phone");
            employeeDAO DAO = employeeDAO.getInstance();

            if (phone.matches("\\d{10,12}")) {
                employeeDTO employee = new employeeDTO(Integer.parseInt(req.getParameter("employeeID")), employeeName, positionID, phone, gmail, null);
                DAO.updateEmployee(employee);
            } else {
                req.setAttribute("error", "Wrong phone format");
            }

            List<employeeDTO> employees = DAO.getEmployees();
            req.setAttribute("employees", employees);

            List<positionDTO> positions = DAO.getPosition();
            req.setAttribute("positions", positions);
        } catch (SQLException | ClassNotFoundException e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

    public void handleDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            employeeDAO DAO = employeeDAO.getInstance();
            DAO.deleteEmployee(Integer.parseInt(req.getParameter("employeeID")));

            List<employeeDTO> employees = DAO.getEmployees();
            req.setAttribute("employees", employees);

            List<positionDTO> positions = DAO.getPosition();
            req.setAttribute("positions", positions);
        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (SQLException | ClassNotFoundException ex) {
            req.setAttribute("error", ex.getMessage());
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }
}
