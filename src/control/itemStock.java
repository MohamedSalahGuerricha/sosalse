package control;

import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class itemStock extends ListCell<Product> implements Initializable {

    @FXML
    private Label lb_qt,lb_state,lb_name,lb_price,lb_qt_stock,lb_barcod;
    @FXML
    private Circle cr_state;
    @FXML
    private AnchorPane anch;

    private FXMLLoader mlloder;
    @Override
    protected void updateItem(Product product,boolean b){
        super.updateItem(product,b);
        if(b || product==null){
            setText(null);
            setGraphic(null);
        }else{
            if(mlloder == null){
                mlloder= new FXMLLoader(getClass().getResource("/fxml/ItemStock.fxml"));
                mlloder.setController(this);
                try {
                    mlloder.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            lb_name.setText(product.getName());
            lb_barcod.setText(String.valueOf(product.getCodpar()));
           System.out.println(product.getId()+"");
            setText(null);
            setGraphic(anch);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
