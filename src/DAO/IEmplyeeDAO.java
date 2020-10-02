package DAO;

import Model.Employee;

import java.util.List;

public interface IEmplyeeDAO {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    int saveEmployee(Employee employee);
    void updateEmployee(Employee employee,int id);
    void deleteEmployee(int id,Boolean reorder);
}
