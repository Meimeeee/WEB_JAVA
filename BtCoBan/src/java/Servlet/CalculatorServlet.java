/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

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
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double a = Double.parseDouble(req.getParameter("a"));
            Double b = Double.parseDouble(req.getParameter("b"));
            
            String operation = req.getParameter("operation");
            Double result = null;
            
            switch(operation){
                case "add" : result = a + b; break;
                case "sub" : result = a - b; break;
                case "mul" : result = a * b; break;
                case "div" : result = (b!=0) ? a / b : 0; break;
                default: throw  new Exception();
            }
            req.setAttribute("result", result);
            
        } catch (NumberFormatException nfe) {
            req.setAttribute("nfe", "Invalid input. Please enter valid numbers.");
        } catch (Exception e){
            req.setAttribute("e", "Error");
        }
        
        req.getRequestDispatcher("calculator.jsp").forward(req, resp);
    }
    
    
}
