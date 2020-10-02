package control;

import DAOImplement.ClientDAOimplement;
import Model.Client;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerUI2 implements Initializable {

    @FXML
    private ListView lv_customers;
    @FXML
    private JFXListView lv_customers2;
    @FXML
    private JFXTextField ed_search;
    @FXML
    private AnchorPane anchor;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadlist();
        // الداله التاليه لاستخراج النص من التكستفيلد عند كل تغير
        ed_search.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equalsIgnoreCase(""))
            {loadlist();}
            else{
                loadlist(newValue);
            }

        });
    }

    private void loadlist() {

        ObservableList<Client> items = FXCollections.observableArrayList();
        ClientDAOimplement clientdao = new ClientDAOimplement();
        List<Client> list = clientdao.getAllClients();
        for (Client c : list) {
            items.addAll(c);
            System.out.println(c.getName());
        }

        lv_customers2.setItems(items);
        //  lv_customers2.setItems(items);
        lv_customers2.setCellFactory(client -> new ItemControlView2());

    }

    private void loadlist(String ss) {
        ObservableList<Client> items = FXCollections.observableArrayList();
        ClientDAOimplement clientdao = new ClientDAOimplement();
        List<Client> list = clientdao.getAllClients();
        // + سنطبق مفهوم ال التاعبير النمطيه " Regular Expressions "
        Pattern p = Pattern.compile(ss);         // + REGEX: هنا النص الذي سنبحث عنه
        for (Client c : list) {
            Matcher m = p.matcher(c.getName()); // هنا ادخلنا النص المراد البحث فسه +
            if (m.lookingAt())
            {   items.addAll(c);}
            //هنا استخدمت كستوم ليستسال حيث اضفت كلاس باسم ItemControlView2
            //      https://www.turais.de/how-to-custom-listview-cell-in-javafx/

            lv_customers2.setItems(items);
            //  lv_customers2.setItems(items);
            lv_customers2.setCellFactory(client -> new ItemControlView2());
        }
    }


    @FXML
    private void refrensNodesfortardes() {
        anchor.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addClient.fxml"));
            Parent root = loader.load();
            AddClient tt = loader.getController();
            loader.setController(tt);

            AnchorPane df =new AnchorPane(root);
            AnchorPane.setLeftAnchor(df, 0.0);
            //AnchorPane.setBottomAnchor(df, 0.0);
            //AnchorPane.setRightAnchor(df, 0.0);
            AnchorPane.setTopAnchor(df, 0.0);
            //  df.setPrefWidth(1280-180.0);

            anchor.getChildren().add(df);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

