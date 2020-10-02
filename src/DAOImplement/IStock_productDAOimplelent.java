package DAOImplement;

import DAO.IStock_productDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Stock_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IStock_productDAOimplelent implements IStock_productDAO {
    private static final String tabel = "`stock_product`";
    private  DatabaseConnection db =new DatabaseConnection();

    @Override
    public List<Stock_product> getAllStock_product() {
        List<Stock_product> list = new ArrayList<Stock_product>();

        db.connect(tabel);
        try {
            ResultSet resultSet=db.select();
            while (resultSet.next()){
                Stock_product stock_product = new Stock_product();
                stock_product.setId(resultSet.getInt(1));
                stock_product.setProduct(resultSet.getNString(2));
                stock_product.setQuntity(resultSet.getInt(3));
                stock_product.setStock(resultSet.getString(4));
                stock_product.setComment(resultSet.getString(5));
                list.add(stock_product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
        return list;
    }

    @Override
    public Stock_product getStock_productById(int id) {
        Stock_product stock_product = new Stock_product();
        db.connect(tabel);
        try {
            ResultSet resultSet=db.select();
                resultSet.next();
                stock_product.setId(resultSet.getInt(1));
                stock_product.setProduct(resultSet.getNString(2));
                stock_product.setQuntity(resultSet.getInt(3));
                stock_product.setStock(resultSet.getString(4));
                stock_product.setComment(resultSet.getString(5));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
        return stock_product;

    }

    @Override
    public void saveStock_product(Stock_product stock_product) {

        Connection con = db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `stock_product` (`id`," +
                    " `product`, `quntity`, `stock`, `comment`) VALUES (NuL,?,?,?,?)");
            preparedStatement.setString(1,stock_product.getProduct());
            preparedStatement.setInt(2,stock_product.getQuntity());
            preparedStatement.setString(3,stock_product.getStock());
            preparedStatement.setString(4,stock_product.getComment());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void updateStock_product(Stock_product stock_product, int id) {
        Connection con = db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `stock_product` SET `product` = ?," +
                    " `quntity` = ?, `stock` = ?, `comment` = ? WHERE `stock_product`.`id` = ?");
            preparedStatement.setString(1,stock_product.getProduct());
            preparedStatement.setInt(2,stock_product.getQuntity());
            preparedStatement.setString(3,stock_product.getStock());
            preparedStatement.setString(4,stock_product.getComment());
            preparedStatement.setInt(5,stock_product.getQuntity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }





    @Override
    public void deleteStock_product(int id, Boolean reorder) {
        db.connect(tabel);
        try {
            db.Delete(id, reorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();



    }
}
