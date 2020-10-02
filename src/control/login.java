package control;

import DAOImplement.EmployeeDAOimplelent;
import Model.Employee;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class login implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public String testlogin(String username_ed,String password_ed, List<Employee> list) {
        String message;
        Map<String, String> map = new HashMap<String, String>();
        for (Employee e : list) {
            map.put(e.getUsername(), e.getPassword());
        }
        if (map.containsKey(username_ed)) {
            String val1 = map.get(username_ed);
            if (val1.equals(password_ed)) {
                message = "تسجيل الدخول بنجاح";
            } else {
                message = "كلمة المرور خاطئه";
            }
        } else {
            message = "المستخدم غير موجود";
        }

    return message;
    }
}
