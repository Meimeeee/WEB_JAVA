/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.AccountDAO;
import java.io.IOException;
import java.sql.SQLException;
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
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("pass");
        String confirmPassword = req.getParameter("confirmPassword");

        AccountDAO DAO = AccountDAO.getInstance();
        if (pass.equals(confirmPassword)) {
            try {
                DAO.createAccount(username, pass);
                resp.sendRedirect("home");
                return;
            } catch (SQLException | ClassNotFoundException ex) {
                req.setAttribute("error", ex.getMessage());
            } catch (Exception e){
                req.setAttribute("error", e.getMessage());
            }
        } else {
            req.setAttribute("error", "Confirm password doesn't match password");
        }
        req.getRequestDispatcher("register.jsp").forward(req, resp);

    }

}
