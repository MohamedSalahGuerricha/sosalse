package DAO;

import Model.Stock_product;

import java.util.List;

public interface IStock_productDAO {

    List<Stock_product> getAllStock_product();
    Stock_product getStock_productById(int id);
    void saveStock_product(Stock_product stock_product);
    void updateStock_product(Stock_product stock_product,int id);
    void deleteStock_product(int id, Boolean reorder);
}
