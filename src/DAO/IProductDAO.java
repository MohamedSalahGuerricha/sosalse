package DAO;

import Model.Product;

import java.util.List;

public interface IProductDAO {

    List<Product> getAllProducts();
    Product getProductById(int id);
    void saveProduct(Product product);
    void updateProduct(Product product,int id);
    void deleteProduct(int id ,Boolean reorder);

}
