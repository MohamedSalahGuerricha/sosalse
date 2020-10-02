package DAOImplement;
import DAO.IClientDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOimplement implements IClientDAO {

    private static  final  String tabel = "client";
    private DatabaseConnection db = new DatabaseConnection();
    private Connection con =db.connect(tabel);

    @Override
    public List<Client> getAllClients() {
        List<Client> listclient = new ArrayList<Client>();


        try {
            ResultSet resultSet = db.select();
            while (resultSet.next()){
                Client client = new Client();
             client.setId(resultSet.getInt(1));
             client.setName(resultSet.getString(2));
             client.setPhone(resultSet.getString(3));
             client.setAdress(resultSet.getString(4));
             client.setType(resultSet.getInt(5));
             client.setNB(resultSet.getString(6));
             client.setCCP(resultSet.getString(7));
             listclient.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listclient;
    }

    @Override
    public Client getClientById(int id) {
        Client client = new Client();
        db.connect(tabel);
        ResultSet resultSet = null;

        try {
            resultSet = db.select(id);
                resultSet.next();
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                client.setPhone(resultSet.getString(3));
                client.setAdress(resultSet.getString(4));
                client.setType(resultSet.getInt(5));
                client.setNB(resultSet.getString(6));
                client.setCCP(resultSet.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return client;
    }

    @Override
    public void saveClient(Client client) {

        db.connect(tabel);

        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `client` (`id`, `name`, `phone`, `adress`, `type`, `NB`, `CCP`) VALUES ( NULL, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getAdress());
            preparedStatement.setString(3,client.getPhone());
            preparedStatement.setInt(4,client.getType());
            preparedStatement.setString(5,client.getNB());
            preparedStatement.setString(6,client.getCCP());

            preparedStatement.executeUpdate();

            System.out.println("saved");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateClient(Client client, int id) {
        String d = "";

        db.connect(tabel);

        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `client` SET `phone` = ?, `adress` = ? , `type` = ?, `NB` = ?, `CCP` = ? WHERE `client`.`id` = ?");
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getAdress());
            preparedStatement.setString(3,client.getPhone());
            preparedStatement.setInt(4,client.getType());
            preparedStatement.setString(5,client.getNB());
            preparedStatement.setString(6,client.getCCP());
            preparedStatement.setInt(7,id);


            preparedStatement.executeUpdate();

            System.out.println("updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteClient(int id, Boolean reorder) {

        db.connect(tabel);

        try {
            db.Delete(id,reorder);
            System.out.println("deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

    }
}
