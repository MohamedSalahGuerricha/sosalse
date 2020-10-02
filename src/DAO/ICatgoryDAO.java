package DAO;

import Model.Catgory;

import java.util.List;

public interface ICatgoryDAO {

    List<Catgory> getAllCatgory();
    Catgory getCatgoryById(int id);
    void saveCatgory(Catgory catgory);
    void updateCatgory(Catgory catgory,int id);
    void deleteCatgory(int id,Boolean reorder);

}
