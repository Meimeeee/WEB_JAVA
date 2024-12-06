/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author ngoct
 */
public class SanPhamDTO {

    private Integer productId;
    private String productName;
    private String productDescription;
    private Integer price;

    public SanPhamDTO() {
    }

    public SanPhamDTO(Integer productId, String productName, String productDescription, Integer price) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
