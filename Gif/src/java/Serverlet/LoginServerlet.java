/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngoct
 */
public class LoginServerlet extends HttpServlet {

    //dev đẩy thông tin lên (chuyển sang url khác)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    //người dùng đẩy thông tin lên (login)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        //req.getParameter(""): lấy thông tin người dùng 
        
        if(userName.equals("long") && password.equals("anhyeuem")){
            resp.sendRedirect("Tym.html");
        } else {
            String error = "Wrong username or password";
            req.setAttribute("error", error);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
        
    }

     

}
