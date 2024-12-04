/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");

        try {

            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);

            if (a <= 0 || b <= 0) {
                throw new Exception("a, b là số nguyên dương");
            }

            String operation = req.getParameter("operation");
            int result = 0;
            switch (operation) {
                case "ucln":
                    result = UCLN(a, b);
                    break;

                case "bcnn":
                    result = BCNN(Integer.parseInt(aStr), Integer.parseInt(bStr));
                    break;

                default:
                    throw new Exception("Không tìm thấy operation");

            }
            req.setAttribute("result", result);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "a và b phải là số nguyên dương");
        } catch (Exception ex) {
//            req.setAttribute("error", "Lỗi người dùng không phải em");
            req.setAttribute("error", ex.getMessage());
        }
        
        req.getRequestDispatcher("calculator.jsp").forward(req, resp);
    }

    public int UCLN(int a, int b) {
        if(a<b) return UCLN(b, a);
        if(a%b==0) return b;
        return UCLN(b, a%b);
    }

    public int BCNN(int a, int b) {
        return Math.abs(a * b) / UCLN(a, b);
    }

}
