package control;

import DAOImplement.CatgoryDAOimplement;
import DAOImplement.ClientDAOimplement;
import DAOImplement.ProductDAOimplement;
import Model.Catgory;
import Model.Client;
import Model.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddProduct  implements Initializable {
    @FXML
    private Label lb_error,lb;
    @FXML
    private JFXTextField ed_name,ed_barcod,ed_class,ed_new_class,ed_price_sell,ed_price_buy,ed_min_stock,ed_comment;
    @FXML
    private  JFXButton bt_barcod,bt_add_class,bt_save_new_class,bt_save;
    @FXML
    private Pane pn_new_class;
    @FXML
    private JFXComboBox co_class;
    @FXML
    private JFXDatePicker dp_date;


    private CatgoryDAOimplement catgorydb = new CatgoryDAOimplement();
    private ProductDAOimplement productdb = new ProductDAOimplement();
    private final ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Catgory> list = catgorydb.getAllCatgory();
        loadcompobox(list);
        new AutoCompleteComboBoxListener<>(co_class); // ا ا https://stackoverflow.com/questions/19924852/autocomplete-combobox-in-javafx  // ظهور القائمه المسندله عند الكتابه
        ed_new_class.clear();
    }

    @FXML
    private void addclass(){
        if(pn_new_class.isVisible()==false)
            pn_new_class.setVisible(true);
            ed_new_class.clear();

    }
    @FXML
    private void addparcod(){

    }
    @FXML
    private void saveclass(){


            List<Catgory> list = catgorydb.getAllCatgory();
            int test =0;
            if (ed_new_class.getText().equalsIgnoreCase("")){
                lb_error.setText("يجب ادخال اسم الصنف")  ;
                Timeline tml = new Timeline(); // الاربع الاسطر المواليه من اجل اخفاء نص الخطأ بعد ثانيه
                KeyFrame move = new KeyFrame(Duration.seconds(1.0), event -> {  lb_error.setText("");tml.stop();});
                tml.getKeyFrames().add(move);
                tml.play();
                test=1;
            }else{
                Pattern pattern= Pattern.compile(ed_name.getText());
                for (Catgory c:list){
                    Matcher matcher=pattern.matcher(c.getName());
                    if(c.getName().equalsIgnoreCase(ed_new_class.getText())){
                        lb_error.setText("الصنف موجود ")  ;
                        Timeline tml = new Timeline();
                        KeyFrame move = new KeyFrame(Duration.seconds(1.0), event -> {  lb_error.setText("");tml.stop();});
                        tml.getKeyFrames().add(move);
                        tml.play();
                        test=1;
                    }

                }

            }
            if(test==0) {
                Catgory catgory = new Catgory(ed_new_class.getText(), null);
                catgorydb.saveCatgory(catgory);
                loadcompobox(ed_new_class.getText());
            }

        }










    @FXML
    private void saveproduct(){
        List<Product> listproduct = productdb.getAllProducts();
        String nameProduct = null;
        int codpar = 0;
        Double priceSell =null;
        Double priceBuy = null;
        Date dateDuree = null;
        System.out.println(dateDuree);
        String namecClass =null;
        int minStock = 0;
        String comment = ed_comment.getText();




        if(ed_name.getText().equalsIgnoreCase("")){
            //يجب ادخال اسم المستخدم
            lb.setText("ادخل اسم المنتج");
        }else{

            if(testFoundProduct(ed_name.getText(),listproduct)){
              //  المنتج موجود بهذا الاسم
                lb.setText("منتج مسجل");
                System.out.println("the proudct is found");
            }else{

                 nameProduct = ed_name.getText();
                 codpar = Integer.parseInt(ed_barcod.getText()); // convert it to int
                 priceSell =Double.valueOf(ed_price_sell.getText());
                 priceBuy = Double.valueOf(ed_price_buy.getText());
                 dateDuree = Date.valueOf(dp_date.getValue());// get and convert date ///////////////

                 namecClass =co_class.getValue().toString();//getItems().toString(); // get and convet catgory
                 minStock = Integer.valueOf( ed_min_stock.getText());// convert to int
                 comment = ed_comment.getText();

                Product product=new Product(nameProduct,codpar,priceSell,priceBuy,dateDuree,namecClass,minStock,null );
                productdb.saveProduct(product);
            }
        }
    }

    private void loadcompobox(String ss){

        co_class.getItems().addAll(ss);
    }
    private void loadcompobox(List<Catgory> list){
        for (Catgory c:list) {
            co_class.getItems().addAll(c.getName());
        }
    }

//    private void createListener() {
//
//        // Create the listener to filter the list as user enters search terms
//        FilteredList<String> filteredList = new FilteredList<>(items);
//
//        // Add listener to our ComboBox textfield to filter the list
//        co_class.getEditor().textProperty().addListener((observable, oldValue, newValue) ->
//                filteredList.setPredicate(item -> {
//
//                    // If the TextField is empty, return all items in the original list
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//
//                    // Check if the search term is contained anywhere in our list
//                    if (item.toLowerCase().contains(newValue.toLowerCase().trim())) {
//                        return true;
//                    }
//
//                    // No matches found
//                    return false;
//                }));
//
//        // Finally, let's add the filtered list to our ComboBox
//        co_class.setItems(filteredList);
//
//    }

    public boolean testFoundProduct(String nameproduct ,List<Product> l){
        boolean b= false ;

        for (Product p:l ) {
            if(nameproduct.equalsIgnoreCase(p.getName()))
                return true;
            }
    return b;
    }


}
