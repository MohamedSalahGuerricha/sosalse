package control;


import DAOImplement.ClientDAOimplement;
import Model.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddClient implements Initializable{

@FXML
private JFXButton bt_save;
@FXML
private JFXTextField ed_name,ed_phone,ed_adrress,ed_ccp,ed_nb;
@FXML
private Label lb_error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private void saveClient(){
        ClientDAOimplement cldb= new ClientDAOimplement();
        List<Client>list = cldb.getAllClients();
        int test = 0;
         if (ed_name.getText().equalsIgnoreCase("")){
             lb_error.setText("يجب ادخال اسم المستخدم")  ;
             Timeline tml = new Timeline(); // الاربع الاسطر المواليه من اجل اخفاء نص الخطأ بعد ثانيه
             KeyFrame move = new KeyFrame(Duration.seconds(1.0), event -> {  lb_error.setText("");tml.stop();});
             tml.getKeyFrames().add(move);
             tml.play();
         }else{
                for (Client c:list){
                    if(c.getName().equalsIgnoreCase(ed_name.getText())){

                        lb_error.setText("المستخدم موجود ")  ;
                        Timeline tml = new Timeline();
                        KeyFrame move = new KeyFrame(Duration.seconds(1.0), event -> {  lb_error.setText("");tml.stop();});
                        tml.getKeyFrames().add(move);
                        tml.play();
                        test=1;
                    }

                }
                if(test==0) {
                    Client client = new Client(ed_name.getText(),ed_phone.getText(),ed_adrress.getText(),1,ed_ccp.getText(),ed_nb.getText());// int 1 : زبون
                    cldb.saveClient(client);

                }
          }
    }

}

