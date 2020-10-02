package control;

import Model.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemControlView2 extends ListCell<Client> implements Initializable {

    @FXML
    private Label lb_name,lb_adrress,lb_phone,l_id,lb_cridi;

    @FXML
    private Button bt1;



    @FXML
    private AnchorPane anch;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if(empty || client == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/ItemCustomer.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) { e.printStackTrace();   }    }
            lb_name.setText(client.getName());
            lb_phone.setText(client.getPhone());
            lb_adrress.setText(client.getAdress());
            l_id.setText(String.valueOf(client.getId()));
            setText(null);
            setGraphic(anch);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bt1.setOnMouseClicked(event ->{
            lb_cridi.setText("cridi");});
        anch.setOnMouseClicked(event ->{
            l_id.setText("id");});
    }

}

