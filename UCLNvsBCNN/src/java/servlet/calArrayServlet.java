/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
public class calArrayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculate-array.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("input");

        if (text == null || text.trim().isEmpty()) {
            req.setAttribute("error", "Nhập lại mảng số");
            req.getRequestDispatcher("calculate-array.jsp").forward(req, resp);
            return;
        }

        String[] array = text.split(",");
        int[] num = new int[array.length];
        try {
            for (int i = 0; i < array.length; i++) {
                num[i] = Integer.parseInt(array[i].trim());
            }

            String func = req.getParameter("func");

            int result = 0;
            switch (func) {
                case "sum":
                    result = sum(num);
                    break;
                case "max":
                    result = max(num);
                    break;
                default:
                    throw new Exception("không tìm thấy chức năng này");
            }

            req.setAttribute("result", result);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Mảng phải là số");
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
        }

        req.getRequestDispatcher("calculate-array.jsp").forward(req, resp);
    }

    public int sum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public int max(int[] a) {
        int max = 0;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
