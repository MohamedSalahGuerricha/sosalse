package control;

import DAOImplement.EmployeeDAOimplelent;
import Model.Debt;
import Model.Employee;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class user implements Initializable {
    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, ?> id;

    @FXML
    private TableColumn<?, ?> username;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> edite;

    @FXML
    private TableColumn<?, ?> delete;

    @FXML
    private Label l_titel_listusers;

    @FXML
    private Pane pa_creation;

    @FXML
    private Label l_titel_creat_user, l_username, l_password, l_repassword,l_error;

    @FXML
    private TextField ed_password;

    @FXML
    private TextField ed_repassword;

    @FXML
    private TextField ed_username;

    @FXML
    private JFXButton bt_creat_user1;

    @FXML
    private JFXButton bt_creat_user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        l_titel_creat_user.setFont(Font.loadFont("file:res/font/Tajawal-Medium.ttf", 14));;
        ed_username.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));;
        ed_password.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));;
        ed_repassword.setFont(Font.loadFont("file:res/font/Tajawal-Medium.ttf", 14));;

        pa_creation.setVisible(false);
        Timeline tml = new Timeline();
        KeyFrame move = new KeyFrame(Duration.seconds(1.0), event -> {  loadtabel();tml.stop();});
        tml.getKeyFrames().add(move);
        tml.play();
        // loadtabel();

    }

       public void handleClicks(ActionEvent event){
          if(pa_creation.isVisible()==false)
              pa_creation.setVisible(true);
          ed_username.clear();
          ed_password.clear();
          ed_repassword.clear();
       }
    private void loadtabel(){
        ObservableList<Employee> data= FXCollections.observableArrayList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        //edite.setCellValueFactory(new PropertyValueFactory<>(""));
        //firstColumn.setPrefWidth(60);

        //add your data to the table here.
        // https://medium.com/@keeptoo/adding-data-to-javafx-tableview-stepwise-df582acbae4f  رابط الشرح
        //                        شرح أخر لكيفية اضافات بيانات للجدول :
        // https://www.youtube.com/watch?v=pPTlDH8FVpM
        // https://drive.google.com/drive/folders/0B_nK3WmoczMgTFhPWmZfby1pQ0k

        EmployeeDAOimplelent employeeDAOimplelent = new EmployeeDAOimplelent();
        List<Employee> listemployee = employeeDAOimplelent.getAllEmployees();
        for(Employee e:listemployee){
            data.add(e);
            table.setItems(data);
        }

    }

    @FXML
    private void  saveuser(ActionEvent event){
           System.out.println("hello world **************************************");
       String  username = ed_username.getText();
       String passowrd =ed_password.getText().toString();
       String repassowrd=ed_repassword.getText().toString();
        EmployeeDAOimplelent employeedb=new EmployeeDAOimplelent();
        List<Employee> employeeList = employeedb.getAllEmployees();

        int ss= testsingup(username,passowrd,repassowrd,employeeList);
        System.out.println(username+"   "+passowrd+"    "+repassowrd);
        System.out.println("the end world **************************************");
        switch (ss) {
            case 0:

             int id= employeedb.saveEmployee(new Employee(username,passowrd,"",1));
                System.out.println(" save employyee his id :"+id);
                loadtabel();

            break;
            case 1:
                System.out.println(" found employyee**************************************");
                l_error.setText("مستخدم موجود❗ ");
                ed_username.clear();
            break;
            case 2:
                System.out.println(" incorrect code employyee******************************");
                l_error.setText("كلمة مرور غير متطابق ⛔ ");
                Timeline tml = new Timeline();
                KeyFrame move = new KeyFrame(Duration.seconds(1.0), ( evjent) -> { l_error.setText("");tml.stop();});
                tml.getKeyFrames().add(move);
                tml.play();

                ed_password.clear();
                ed_repassword.clear();

                break;

        }

       }


    public int testsingup(String username_ed,String password_ed,String repassword_ed, List<Employee> list) {
        int err = 0;

        if ( password_ed.equalsIgnoreCase(repassword_ed)) {
            for (Employee e : list) {
                if (username_ed.equalsIgnoreCase(e.getUsername())) {
                    // خطأ مستخدم موجود
                    err =    1;
                    break;
                }
            }
        }else{
            // خطأ عدم تطابق كلمة المرور
            err = 2;
        }
        return err;
    }
}
