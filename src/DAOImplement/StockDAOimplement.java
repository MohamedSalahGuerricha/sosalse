package DAOImplement;

import DAO.IStockDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAOimplement implements IStockDAO {
private static final String tabel = "";
private DatabaseConnection db = new DatabaseConnection();
    @Override
    public List<Stock> getAllStock() {
        List<Stock> liststock = new ArrayList<Stock>();

        db.connect(tabel);
        try {
            ResultSet resultSet = db.select();
            while(resultSet.next()){
                Stock stock = new Stock();
                stock.setId(resultSet.getInt(1));
                stock.setName(resultSet.getString(2));
                stock.setAdress(resultSet.getString(3));
                stock.setAdmin(resultSet.getString(4));
                liststock.add(stock);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return liststock;
    }

    @Override
    public Stock getStockById(int id) {
        Stock stock = new Stock();
        db.connect(tabel);
        try {
             ResultSet resultSet = db.select();
             resultSet.next();

                stock.setId(resultSet.getInt(1));
                stock.setName(resultSet.getString(2));
                stock.setAdress(resultSet.getString(3));
                stock.setAdmin(resultSet.getString(4));




        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return null;
    }

    @Override
    public void saveStock(Stock stock) {

        Connection con = db.connect(tabel);
        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO `stock` (`id`, `name`, `adress`, `admin`) VALUES (NULL, ?, ?, ?)");
            ps.setString(1,stock.getName());
            ps.setString(2,stock.getAdress());
            ps.setString(3,stock.getAdmin());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void updateStock(Stock stock, int id) {

        Connection con = db.connect(tabel);
        try {

            PreparedStatement ps = con.prepareStatement("UPDATE `stock` SET `name` = ?, `adress` = ? , `admin`= ? WHERE `stock`.`id` = ?");
            ps.setString(1,stock.getName());
            ps.setString(2,stock.getAdress());
            ps.setString(3,stock.getAdmin());
            ps.setInt(4,stock.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void deleteStock(int id, Boolean reorder) {
     db.connect(tabel);

        try {
            db.Delete(id, reorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
}
