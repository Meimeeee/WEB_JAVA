/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngoct
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String pass = req.getParameter("pass");
            AccountDTO account = new AccountDTO(null, username, pass);

            AccountDAO DAO = AccountDAO.getInstance();
            account = DAO.getAccount(account);

            if (account == null) {
                req.setAttribute("error", "Wrong username or password");
            } else {
                resp.sendRedirect("home");
                return;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            req.setAttribute("error", ex.getMessage());
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}
