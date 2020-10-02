package control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemControlView implements Initializable {



    private  int id;

    public void setItemControlView(String clientName, String phoneNumber, String cridi,int id) {
        lb_name.setText(clientName);
        lb_phone.setText(phoneNumber);
        lb_cridi.setText(cridi);
        this.id=id;
    }

    public ItemControlView() {

    }


    @FXML
    private Label lb_name;

    @FXML
    private Label lb_phone;

    @FXML
    private Label lb_cridi,l_id;
    @FXML
    private Button bt1;
    @FXML
    private AnchorPane anch;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


bt1.setOnMouseClicked(event ->{
    lb_cridi.setText("cridi");});
anch.setOnMouseClicked(event ->{
    l_id.setText(""+id);});
    }


}
