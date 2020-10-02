package control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TardesView implements Initializable {

   /* private String data;

    public TardesView(String data) {
        this.data = data;
    }
*/
    @FXML
    private Label lb_phone ,labb;




    public void initialize(URL location, ResourceBundle resources) {
    //lb_phone.setText(data);
    }

    public void setdata(String ss){
        labb.setText(ss);

    }
}
