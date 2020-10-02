package DAOImplement;

import DAO.IProductDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimplement implements IProductDAO {
    private static final String tabel="product";
    private  DatabaseConnection db = new DatabaseConnection();
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();

        db.connect(tabel);

        try {
            ResultSet resultSet = db.select();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setCodpar(resultSet.getInt(3));
                product.setSelling_price(resultSet.getDouble(4));
                product.setPurchasing_price(resultSet.getDouble(5));
                product.setExpiration_date(resultSet.getDate(6));
                product.setCatgory(resultSet.getString(7));
                product.setMinmum_stock(resultSet.getInt(8));
                product.setComment(resultSet.getString(9));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
        return productList;
    }

    @Override
    public Product getProductById(int id) {

        Product product = new Product();
        db.connect(tabel);

        try {

            ResultSet resultSet = db.select();

            resultSet.next();
            product.setId(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setCodpar(resultSet.getInt(3));
            product.setSelling_price(resultSet.getDouble(4));
            product.setPurchasing_price(resultSet.getDouble(5));
            product.setExpiration_date(resultSet.getDate(6));
            product.setCatgory(resultSet.getString(7));
            product.setMinmum_stock(resultSet.getInt(8));
            product.setComment(resultSet.getString(9));



        } catch (SQLException e) {
            e.printStackTrace();
        }
db.disconnect();
        return product;


    }

    @Override
    public void saveProduct(Product product) {

        Connection con = db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `product` (`id`, `name`, `codpar`, `selling_price`, `Purchasing_price`, `Expiration_date`, `catgory`, `minmum_stock` ,`comment`) VALUES (NULL , ?, ?, ?, ?, ?, ?, ?,?)");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getCodpar());
            preparedStatement.setDouble(3,product.getSelling_price());
            preparedStatement.setDouble(4,product.getPurchasing_price());
            preparedStatement.setDate(5,product.getExpiration_date());
            preparedStatement.setString(6,product.getCatgory());
            preparedStatement.setInt(7,product.getMinmum_stock());
            preparedStatement.setString(8,product.getComment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
db.disconnect();

    }

    @Override
    public void updateProduct(Product product, int id) {


        Connection con = db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `product` SET `name` =  ? , " +
                    "`codpar` =  ? , `selling_price` =  ? , `Purchasing_price` =  ? , `Expiration_date` = ? ," +
                    " `catgory` = ? , `minmum_stock` = ?, `comment` = ? WHERE `product`.`id` = ?");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getCodpar());
            preparedStatement.setDouble(3,product.getSelling_price());
            preparedStatement.setDouble(4,product.getPurchasing_price());
            preparedStatement.setDate(5,product.getExpiration_date());
            preparedStatement.setString(6,product.getCatgory());
            preparedStatement.setInt(7,product.getMinmum_stock());
            preparedStatement.setString(8,product.getComment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();



    }

    @Override
    public void deleteProduct(int id, Boolean reorder) {
db.connect(tabel);
        try {
            db.Delete(id,reorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
}
