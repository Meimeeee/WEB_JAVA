/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.productDAO;
import src.productDTO;

/**
 *
 * @author ngoct
 */
public class productServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productDAO DAO = productDAO.getInstance();
        List<productDTO> listProduct = DAO.getList();
        req.setAttribute("listProduct", listProduct);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        switch (operation) {
            case "add":
                handleAddProduct(req, resp);
                break;

            case "update":
                handleUpdateProduct(req, resp);
                break;

            case "delete":
                handleDeleteProduct(req, resp);
                break;

            default:
                throw new ServletException("Not found operation");
        }
    }

    public void handleAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String productName = req.getParameter("productName");
            String productDescription = req.getParameter("productDescription");
            Integer productPrice = Integer.parseInt(req.getParameter("productPrice"));

            productDTO product = new productDTO(null, productName, productDescription, productPrice);

            productDAO DAO = productDAO.getInstance();
            DAO.add(product);

            List<productDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);
            
        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    public void handleUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Integer productId = Integer.parseInt(req.getParameter("productId"));
            String productName = req.getParameter("productName");
            String productDescription = req.getParameter("productDescription");
            Integer productPrice = Integer.parseInt(req.getParameter("productPrice"));

            productDTO product = new productDTO(productId, productName, productDescription, productPrice);
            productDAO DAO = productDAO.getInstance();
            DAO.update(product);

            List<productDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);

        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    public void handleDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            
            productDAO DAO = productDAO.getInstance();
            DAO.delete(productId);
            
            List<productDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);
            
        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (Exception e){
            req.setAttribute("error", e.getMessage());
        }
        
        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }
    
    

}
