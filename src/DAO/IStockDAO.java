package DAO;

import Model.Stock;

import java.util.List;

public interface IStockDAO {

    List<Stock> getAllStock();
    Stock getStockById(int id);
    void saveStock(Stock stock);
    void updateStock(Stock stock,int id);
    void deleteStock(int id , Boolean reorder);

}
