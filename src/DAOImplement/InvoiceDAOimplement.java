package DAOImplement;

import DAO.IINvoiceDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOimplement implements IINvoiceDAO {
    private static final String tabel = "";
    private DatabaseConnection db = new DatabaseConnection();


    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoiceList = new ArrayList<Invoice>();

        Connection con = db.connect(tabel);
        try {
            ResultSet  resultSet = db.select();
            while(resultSet.next()){
                Invoice invoice = new Invoice();
                invoice.setId(resultSet.getInt(1));
                invoice.setClient(resultSet.getString(2));
                invoice.setTotal(resultSet.getDouble(3));
                invoice.setDebt(resultSet.getDouble(4));
                invoice.setEmployee(resultSet.getString(5));
                invoice.setDate(resultSet.getDate(6));
                invoice.setComment(resultSet.getString(7));
                invoiceList.add(invoice);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
db.disconnect();

        return invoiceList;
    }

    @Override
    public Invoice getInvoiceById(int id) {

        Invoice invoice = new Invoice();
        Connection con = db.connect(tabel);
        try {
            ResultSet  resultSet = db.select(id);

                resultSet.next();
                invoice.setId(resultSet.getInt(1));
                invoice.setClient(resultSet.getString(2));
                invoice.setTotal(resultSet.getDouble(3));
                invoice.setDebt(resultSet.getDouble(4));
                invoice.setEmployee(resultSet.getString(5));
                invoice.setDate(resultSet.getDate(6));
                invoice.setComment(resultSet.getString(7));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

        return invoice;
    }

    @Override
    public void saveInvoice(Invoice invoice) {

        Connection con =db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `invoice` (`id`, `client`, `Total`, `debt`, `employee`, `date`, `comment`) VALUES (null , ?, ?, ?,?, ?, ?)");
            preparedStatement.setString(1,invoice.getClient());
            preparedStatement.setDouble(2,invoice.getTotal());
            preparedStatement.setDouble(3,invoice.getDebt());
            preparedStatement.setString(4,invoice.getEmployee());
            preparedStatement.setDate(5,invoice.getDate());
            preparedStatement.setString(6,invoice.getComment());

        } catch (SQLException e) {
            e.printStackTrace();
        }
db.disconnect();
    }

    @Override
    public void updateInvoice(Invoice invoice, int id) {
        Connection con =db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `invoice` SET `client`=?," +
                    "`Total` = ?, `debt` = ?,`employee`=?, `date` = ?, `comment` = ? WHERE `invoice`.`id` = ?");
            preparedStatement.setString(1,invoice.getClient());
            preparedStatement.setDouble(2,invoice.getTotal());
            preparedStatement.setDouble(3,invoice.getDebt());
            preparedStatement.setString(4,invoice.getEmployee());
            preparedStatement.setDate(5,invoice.getDate());
            preparedStatement.setString(6,invoice.getComment());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void deleteInvoice(int id, Boolean reorder) {
        db.connect(tabel);
        try {
            db.Delete(id,reorder);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
}
