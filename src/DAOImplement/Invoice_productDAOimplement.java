package DAOImplement;

import DAO.IInvoice_productDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Invoice_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Invoice_productDAOimplement implements IInvoice_productDAO {
    private  static final String tabel = "`invoice_product`";
    private  DatabaseConnection db = new DatabaseConnection();
    @Override
    public List<Invoice_product> getAllInvoice_product() {
        List<Invoice_product> list = new ArrayList<Invoice_product>();

        db.connect(tabel);
        ResultSet resultSet = null;
        try {
            resultSet = db.select();

            while (resultSet.next()){
                Invoice_product ivp = new Invoice_product();
                ivp.setInvoices_id(resultSet.getInt(1));
                ivp.setProduct(resultSet.getNString(2));
                ivp.setPrice(resultSet.getDouble(3));
                ivp.setAmount(resultSet.getDouble(4));
                ivp.setQuntity(resultSet.getInt(5));
                ivp.setComment(resultSet.getString(6));
                list.add(ivp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return list;
    }

    @Override
    public Invoice_product getInvoice_productById(int id) {
        Invoice_product ivp = new Invoice_product();
        db.connect(tabel);
        ResultSet resultSet = null;
        try {
            resultSet = db.select();

            resultSet.next();
                ivp.setInvoices_id(resultSet.getInt(1));
                ivp.setProduct(resultSet.getNString(2));
                ivp.setPrice(resultSet.getDouble(3));
                ivp.setAmount(resultSet.getDouble(4));
                ivp.setQuntity(resultSet.getInt(5));
                ivp.setComment(resultSet.getString(6));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return ivp;
    }

    @Override
    public void saveInvoice_product(Invoice_product invoice_product) {
        Connection con=  db.connect(tabel);
        try {
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `invoice_product` (`id`," +
                " `invoices_id`, `product`, `price`, `amount`, `quntity`, `comment`)  VALUES (null, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1,invoice_product.getInvoices_id());
        preparedStatement.setString(2,invoice_product.getProduct());
        preparedStatement.setDouble(3,invoice_product.getPrice());
        preparedStatement.setDouble(4,invoice_product.getAmount());
        preparedStatement.setInt(5,invoice_product.getQuntity());
        preparedStatement.setString(6,invoice_product.getComment());
        preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
       db.disconnect();
    }

    @Override
    public void updateInvoice_product(Invoice_product invoice_product, int id) {

        Connection con=  db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `invoice_product` SET " +
                    "`invoices_id` = ?, `product` =  ?, `price` =  ?, `amount` =  ?, `quntity` =  ?," +
                    " `comment` =  ? WHERE `invoice_product`.`id` = ?");
            preparedStatement.setInt(1,invoice_product.getInvoices_id());
            preparedStatement.setString(2,invoice_product.getProduct());
            preparedStatement.setDouble(3,invoice_product.getPrice());
            preparedStatement.setDouble(4,invoice_product.getAmount());
            preparedStatement.setInt(5,invoice_product.getQuntity());
            preparedStatement.setString(6,invoice_product.getComment());
            preparedStatement.setInt(7,invoice_product.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();


    }

    @Override
    public void deleteInvoice_product(int id,Boolean reorder) {
          db.connect(tabel);
        try {
            db.Delete(id,reorder);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
}
