/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class ProductDAO {

    public static ProductDAO intstance;

    public static ProductDAO getInstance() {
        if (intstance == null) {
            intstance = new ProductDAO();
        }
        return intstance;
    }

    

    public List<ProductDTO> getList() throws SQLException, ClassNotFoundException {
        List<ProductDTO> data = new ArrayList<ProductDTO>();
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM product");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProductDTO product = new ProductDTO(rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("product_description"),
                    rs.getLong("product_price")
            );
            data.add(product);
        }

        return data;
    }

    public void add(ProductDTO product) throws SQLException, ClassNotFoundException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("INSERT INTO product(product_name, product_description, product_price) VALUES(?, ?, ?)");
        ps.setString(1, product.getProductName());
        ps.setString(2, product.getProductDescription());
        ps.setLong(3, product.getProductPrice());
        ps.execute();
    }

    public void update(ProductDTO product) throws SQLException, ClassNotFoundException {
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("UPDATE product SET "
                + "product_name = ?, product_description = ?, product_price = ? WHERE product_id = ?");
        ps.setString(1, product.getProductName());
        ps.setString(2, product.getProductDescription());
        ps.setLong(3, product.getProductPrice());
        ps.setInt(4, product.getProductId());
        ps.execute();
    }

    public void delete(Integer productId) throws SQLException, ClassNotFoundException{
        Connection connect = JDBC.ConnectJDBC.getConnect();
        PreparedStatement ps = connect.prepareStatement("DELETE FROM product WHERE product_id = ?");
        ps.setInt(1, productId);
        ps.execute();
    }

}
