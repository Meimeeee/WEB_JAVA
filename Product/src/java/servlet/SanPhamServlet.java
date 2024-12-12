/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.SanPhamDAO;
import src.SanPhamDTO;

/**
 *
 * @author ngoct
 */
public class SanPhamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPhamDAO sanPhamDAO = SanPhamDAO.getInstance();
        List<SanPhamDTO> listSanPham = sanPhamDAO.getList();
        req.setAttribute("listSanPham", listSanPham);
        req.getRequestDispatcher("sanpham.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        switch (operation) {
            case "them":
                handleThemSanPham(req, resp);
                break;

            case "sua":
                handleSuaSanPham(req, resp);
                break;

            case "xoa":
                handleXoaSanPham(req, resp);
                break;

            default:
                throw new ServletException("Khong tim thay operation");
        }
    }

    private void handleThemSanPham(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String productName = req.getParameter("productName");
            String productDescription = req.getParameter("productDescription");
            Integer productPrice = Integer.parseInt(req.getParameter("productPrice"));

            SanPhamDTO sanPham = new SanPhamDTO(null, productName, productDescription, productPrice);
            SanPhamDAO sanphamDAO = SanPhamDAO.getInstance();
            sanphamDAO.create(sanPham);

            List<SanPhamDTO> listSanPham = sanphamDAO.getList();
            req.setAttribute("listSanPham", listSanPham);

        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Sai dinh dang so");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("sanpham.jsp").forward(req, resp);
    }

    private void handleSuaSanPham(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            String productName = req.getParameter("productName");
            String productDescription = req.getParameter("productDescription");
            Integer productPrice = Integer.parseInt(req.getParameter("productPrice"));

            SanPhamDTO sanPham = new SanPhamDTO(productId, productName, productDescription, productPrice);
            SanPhamDAO sanPhamDAO = SanPhamDAO.getInstance();
            sanPhamDAO.update(sanPham);

            List<SanPhamDTO> listSanPham = sanPhamDAO.getList();
            req.setAttribute("listSanPham", listSanPham);

        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Sai dinh dang so");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("sanpham.jsp").forward(req, resp);
    }

    private void handleXoaSanPham(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));

            SanPhamDAO sanPhamDAO = SanPhamDAO.getInstance();
            sanPhamDAO.delete(productId);

            List<SanPhamDTO> listSanPham = sanPhamDAO.getList();
            req.setAttribute("listSanPham", listSanPham);
            
        } catch (NumberFormatException nfe) {
            req.setAttribute("error", "Sai dinh dang so");
        } catch (Exception e){
            req.setAttribute("error", e.getMessage());
        }
        
        req.getRequestDispatcher("sanpham.jsp").forward(req, resp);
    }

}
