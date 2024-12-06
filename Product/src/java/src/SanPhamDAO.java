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
public class SanPhamDAO {

    private static SanPhamDAO instance;

    public static SanPhamDAO getInstance() {
        if (instance == null) {
            instance = new SanPhamDAO();
        }
        return instance;
    }

    private List<SanPhamDTO> data;
    private int lastIndex;
    private SanPhamDAO() {
        data = new ArrayList<>();
        data.add(new SanPhamDTO(1, "San pham 1", "Mo ta cua san pham 1", 100000));
        data.add(new SanPhamDTO(2, "San pham 2", "Mo ta cua san pham 2", 50000));
        data.add(new SanPhamDTO(3, "San pham 3", "Mo ta cua san pham 3", 300000));
        data.add(new SanPhamDTO(4, "San pham 4", "Mo ta cua san pham 4", 1000000));
        data.add(new SanPhamDTO(5, "San pham 5", "Mo ta cua san pham 5", 600000));
    
        
        lastIndex = data.size();
    }
    
    public List<SanPhamDTO> getList(){
        
        return data;
    }
    
    public void create(SanPhamDTO sanPham){
        sanPham.setProductId(++lastIndex);
        data.add(sanPham);
    }
    
    public void update(SanPhamDTO sanPham) throws Exception{
        for (int i = 0; i < data.size(); i++) {
            SanPhamDTO tmp = data.get(i);
            
            if(tmp.getProductId().equals(sanPham.getProductId())){
                data.set(i, sanPham);
                return;
            }
        }
        throw new Exception("Khong tim thay san pham");
    }
    
    public void delete(Integer productId) throws Exception{
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getProductId().equals(productId)){
                data.remove(i);
                return;
            }
        }
        throw new Exception("Khong tim thay san pham");
    }
    
}
