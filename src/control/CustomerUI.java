package control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerUI implements Initializable {

    private ItemControlView view;
    private List<ItemControlView> viewList;

    public ItemControlView getView() {
        return view;
    }

    public void setView(ItemControlView view) {
        this.view = view;
    }

    public List<ItemControlView> getViewList() {
        return viewList;
    }

    public void setViewList(List<ItemControlView> viewList) {
        this.viewList = viewList;
    }

    @FXML
    private GridPane gp_listcustomer;
    @FXML
    private ScrollPane sp_listucustomer;

    @FXML
    private Label label;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refrensNodesoneline();
        sp_listucustomer.setPannable(true);
        sp_listucustomer.setContent(gp_listcustomer);
    }

    private void refrensNodes(){
        Node[][] nodes =new Node[18][4];
        int id = 0;
        for (int i=1;i<18;i++){
            for (int j=1;j<4;j++) {
                try {
                    id++;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ItemCustomer.fxml"));
                    Parent root = loader.load();
                    ItemControlView tt = loader.getController();
                    tt.setItemControlView("ali : "+i,"0699","34.99",j+i);
                    loader.setController(tt);
                    // AnchorPane df =new AnchorPane(root);
                    nodes[i][j] = (Node) FXMLLoader.load(getClass().getResource("../fxml/ItemCustomer.fxml"));
                    gp_listcustomer.add(root, j, i);
                    sp_listucustomer.setContent(gp_listcustomer);
                } /*catch (IOException e) {
                    e.printStackTrace();
                }*/ catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        gp_listcustomer.getChildren().addAll();
    }
    private void refrensNodesoneline(){
//        gp_listcustomer.getChildren().clear();
        Node[] nodes =new Node[18];
        int id = 0;
        for (int i=1;i<18;i++){
                try {
                    id++;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ItemCustomer.fxml"));
                    Parent root = loader.load();
                    ItemControlView tt = loader.getController();
                    tt.setItemControlView("ali : "+i,"0699","34.99",i);
                    loader.setController(tt);
                    // AnchorPane df =new AnchorPane(root);
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("../fxml/ItemCustomer.fxml"));
                    gp_listcustomer.add(root, 1, i);
                    sp_listucustomer.setContent(gp_listcustomer);
                } /*catch (IOException e) {
                    e.printStackTrace();
                }*/ catch (Exception e) {
                    e.printStackTrace();
                }
            }
        gp_listcustomer.getChildren().addAll();
    }

    public void  onclic(MouseEvent event) {
     label.setText("tladhet");
    }

}
