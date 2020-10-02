package DAOImplement;

import DAO.ICatgoryDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Catgory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatgoryDAOimplement implements ICatgoryDAO {
    private static  final  String tabel = "catgory";
    private DatabaseConnection db = new DatabaseConnection();


    @Override
    public List<Catgory> getAllCatgory() {
        List<Catgory> list =  new ArrayList<Catgory>();

        db.connect(tabel);
        try {

           ResultSet rs = db.select();
            while (rs.next()){
                Catgory catgory =new Catgory();
                catgory.setId(rs.getInt(1));
                catgory.setName(rs.getString(2));
                catgory.setType(rs.getString(3));
                list.add(catgory);
                System.out.println("add sacsess");
            }
            db.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Catgory getCatgoryById(int id) {
        Catgory catgory =new Catgory();
        db.connect(tabel);
        try {
            ResultSet rs = db.select(id);
            rs.next();
                catgory.setId(rs.getInt(1));
                catgory.setName(rs.getString(2));
                catgory.setType(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
       db.disconnect();
        return catgory;
    }

    @Override
    public void saveCatgory(Catgory catgory) {
       // DatabaseConnection db = new DatabaseConnection();
        Connection con =db.connect(tabel);
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `catgory`(`id`, `name`, `type`) VALUES (null,?,?)");
            pstmt.setString(1,catgory.getName());
            pstmt.setString(2,catgory.getType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void updateCatgory(Catgory catgory,int id) {

        Connection con =db.connect(tabel);
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `catgory` SET `id`= "+id+" ,`name`=?,`type`=? WHERE id = ?");
            pstmt.setString(1,catgory.getName());
            pstmt.setString(2,catgory.getType());
            pstmt.setInt(3,id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

    @Override
    public void deleteCatgory(int id,Boolean reorder) {

        db.connect(tabel);
        try {
            db.Delete(id,reorder);
            System.out.println("delted it ok ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
}
