/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoct
 */
public class productDAO {

    public static productDAO intstance;

    public static productDAO getInstance() {
        if (intstance == null) {
            intstance = new productDAO();
        }
        return intstance;
    }

    private List<productDTO> data;
    private int lastIndex;

    private productDAO() {
        data = new ArrayList<>();
        data.add(new productDTO(1, "San pham 1", "Mo ta cua san pham 1", 100000));
        data.add(new productDTO(2, "San pham 2", "Mo ta cua san pham 2", 50000));
        data.add(new productDTO(3, "San pham 3", "Mo ta cua san pham 3", 300000));
        data.add(new productDTO(4, "San pham 4", "Mo ta cua san pham 4", 1000000));
        data.add(new productDTO(5, "San pham 5", "Mo ta cua san pham 5", 600000));
        lastIndex = data.size();
    }

    public List<productDTO> getList() {
        return data;
    }

    public void add(productDTO product) {
        product.setProductId(++lastIndex);
        data.add(product);
    }

    public void update(productDTO product) throws Exception {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getProductId().equals(product.getProductId())) {
                data.set(i, product);
                return;
            }
        }
        throw new Exception("Not found product ID");
    }

    public void delete(Integer productId) throws Exception {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getProductId().equals(productId)) {
                data.remove(i);
                return;
            }
        }
        throw new Exception("Not found product");
    }

}
