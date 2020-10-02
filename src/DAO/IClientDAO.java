package DAO;

import Model.Client;

import java.util.List;

 public interface IClientDAO {

    List<Client> getAllClients();
    Client getClientById(int id);
    void saveClient(Client client);
    void updateClient(Client client,int id);
    void deleteClient(int id,Boolean reorder);
}
