package ra.service;

import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService{
    static List<Product> products;
    public ProductService(){
        products = new ArrayList<>();
    }
    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public Object findById(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }
    public Product findById(String id){
        for (Product pro: products) {
            if(pro.getProductId().equals(id)){
                // tìm thấy
                return pro;
            }
        }
        // không tìm thấy
        return null;
    }
    public List<Product> getAllProducts() {
        return products;
    }
    public int getSize() {
        return products.size();
    }
    public void save(Product product){
        if(findById(product.getProductId())==null){
            // chức năng thêm mới
            products.add(product);
        }else {
            // update
           products.set(products.indexOf(findById(product.getProductId())),product);
        }
    }
    public  void deletePro(String idDel){
        if(findById(idDel) == null){
            // không ton tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        products.remove(findById(idDel));
    }
}
