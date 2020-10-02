package DAOImplement;

import DAO.IDebtDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Debt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DebtDAOimplement implements IDebtDAO {


    private static  final  String tabel = "`debt`";
    private DatabaseConnection db = new DatabaseConnection();


    @Override
    public List<Debt> getAllDebts() {
        List<Debt> listdebt = new ArrayList<Debt>();

        db.connect(tabel);

        try {

            ResultSet resultSet = db.select();

            while (resultSet.next()){
                Debt debt = new Debt();
                debt.setId(resultSet.getInt(1));
                debt.setAmount(resultSet.getDouble(2));
                debt.setClient(resultSet.getString(3));
                debt.setEmployee(resultSet.getString(4));
                debt.setDate(resultSet.getDate(5));
                debt.setComment(resultSet.getString(6));
                listdebt.add(debt);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listdebt;
    }

    @Override
    public Debt getDebtById(int id) {

        Debt debt = new Debt();
        db.connect(tabel);

        try {

            ResultSet resultSet = db.select();

           resultSet.next();
                debt.setId(resultSet.getInt(1));
                debt.setAmount(resultSet.getDouble(2));
                debt.setClient(resultSet.getString(3));
                debt.setEmployee(resultSet.getString(4));
                debt.setDate(resultSet.getDate(5));
                debt.setComment(resultSet.getString(6));




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debt;
    }

    @Override
    public void saveDebt(Debt debt) {

        Connection connection =  db.connect(tabel);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `debt` (`id`, `client`, " +
                    "`amount`, `employee`, `date`, `comment`) VALUES (NULL , ?,  ?, ?, ?, ?);");
            preparedStatement.setString(1,debt.getClient());
            preparedStatement.setDouble(2,debt.getAmount());
            preparedStatement.setString(3,debt.getEmployee());
            preparedStatement.setDate(4,debt.getDate());
            preparedStatement.setString(5,debt.getComment());


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

    }

    @Override
    public void updateDebt(Debt debt,int id) {

        Connection connection =  db.connect(tabel);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `debt` SET `id` = NULL, `client` = ? ,`amount` = ? , `employee` = ? , `date`= ? , `comment` = ? WHERE `debt`.`id` = ?; (`id`,  `comment` " );
            preparedStatement.setString(1,debt.getClient());
            preparedStatement.setDouble(2,debt.getAmount());
            preparedStatement.setString(3,debt.getEmployee());
            preparedStatement.setDate(4,debt.getDate());
            preparedStatement.setString(5,debt.getComment());
            preparedStatement.setInt(6,debt.getId());


        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();


    }

    @Override
    public void deleteDebt(int id , Boolean reorder) {
db.connect(tabel);
        try {
            db.Delete(id,reorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
db.disconnect();

    }
}


//INSERT INTO `employee` (`id`, `username`, `password`, `phone`, `type`) VALUES ('1', 'salah', '1234', '0699821139', '1');