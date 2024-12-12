/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.ProductDAO;
import src.ProductDTO;

/**
 *
 * @author ngoct
 */
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductDAO DAO = ProductDAO.getInstance();
            List<ProductDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);
            
//            req.setAttribute("error", "?????????????????");
        } catch (SQLException ex) {
            req.setAttribute("error", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void handleAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        try {
            String productName = req.getParameter("productName");
            String productDescription = req.getParameter("productDescription");
            Long productPrice = Long.parseLong(req.getParameter("productPrice"));

            ProductDTO product = new ProductDTO(null, productName, productDescription, productPrice);

            ProductDAO DAO = ProductDAO.getInstance();
            DAO.add(product);

            List<ProductDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);

        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (SQLException e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    public void handleUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        try {

            Integer productId = Integer.parseInt(req.getParameter("productId"));
            String productName = req.getParameter("productName");
            String productDescription = req.getParameter("productDescription");
            Long productPrice = Long.parseLong(req.getParameter("productPrice"));

            ProductDTO product = new ProductDTO(productId, productName, productDescription, productPrice);
            ProductDAO DAO = ProductDAO.getInstance();
            DAO.update(product);

            List<ProductDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);

        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (SQLException e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

    public void handleDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ClassNotFoundException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));

            ProductDAO DAO = ProductDAO.getInstance();
            DAO.delete(productId);

            List<ProductDTO> listProduct = DAO.getList();
            req.setAttribute("listProduct", listProduct);

        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Wrong number format");
        } catch (SQLException e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("product.jsp").forward(req, resp);
    }

}
