package DAOImplement;

import DAO.IEmplyeeDAO;
import DatabaseConnection.DatabaseConnection;
import Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimplelent implements IEmplyeeDAO {
    private static  final  String tabel = "`employee`";
    private  DatabaseConnection db = new DatabaseConnection();
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> listemployees = new ArrayList<Employee>();

        db.connect(tabel);
        try {
                ResultSet resultSet = db.select();
                while (resultSet.next()){
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt(1));
                    employee.setUsername(resultSet.getString(2));
                    employee.setPassword(resultSet.getNString(3));
                    employee.setPhone(resultSet.getString(4));
                    employee.setType(resultSet.getInt(5));

                    listemployees.add(employee);

                                    }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return listemployees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        db.connect(tabel);
        try {

                ResultSet resultSet = db.select(id);
                resultSet.next();
                employee.setId(resultSet.getInt(1));
                employee.setUsername(resultSet.getString(2));
                employee.setPassword(resultSet.getNString(3));
                employee.setPhone(resultSet.getString(4));
                employee.setType(resultSet.getInt(5));


        }catch (SQLException e){
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public int saveEmployee(Employee employee) {
        int  b =0;
        Connection con = db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `employee` (`id`, " +
                    "`username`, `password`, `phone`, `type`) VALUES (null, ?, ?, ?, ?)");
            preparedStatement.setString(1,employee.getUsername());
            preparedStatement.setString(2,employee.getPassword());
            preparedStatement.setString(3,employee.getPhone());
            preparedStatement.setInt(4,employee.getType());
            b=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
       return b;
    }

    @Override
    public void updateEmployee(Employee employee, int id) {

        Connection con = db.connect(tabel);
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE `employee` SET `username` = ?, `password` = ?, `phone` = ?, `type` = ? WHERE `employee`.`id` = ?");
            preparedStatement.setString(1,employee.getUsername());
            preparedStatement.setString(2,employee.getPassword());
            preparedStatement.setString(3,employee.getPhone());
            preparedStatement.setInt(4,employee.getType());
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();


    }

    @Override
    public void deleteEmployee(int id,Boolean reoder) {
        db.connect(tabel);

        try {
            db.Delete(id,reoder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();

    }
}
