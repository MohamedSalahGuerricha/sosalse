package control;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.Toolkit.getDefaultToolkit;

public class Controller implements Initializable {
    @FXML
    private Pane pnlstatus1,vb;

    @FXML
    private Label lb_titel, lb_res,lb_shortcut;

    @FXML
    private Button bt_users,bt_fa_sell,bt_fa_buy,bt_castomer,bt_tard,bt_stock,bt_credi,bt_stastic;

    @FXML
    private Button bt_open_private3;

    @FXML
    private AnchorPane rootanchor, patren;

    @FXML
    private FontAwesomeIconView bt_close1;
    @FXML
    private GridPane gpa;

    private static final String res_users="/fxml/users.fxml";
    private static final String res_factir="/fxml/factir.fxml";
    private static final String res_customer="/fxml/customer2.fxml";
    private static final String res_stock="/fxml/stock.fxml";
    private static final String res_tard="/fxml/tard.fxml";
    private static final String res_stastic="/fxml/stastic.fxml";
    private static final String res_cridi="/fxml/cridi.fxml";

    private double width ;
    private double height ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bt_users.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_castomer.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_fa_buy.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_fa_sell.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_tard.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_credi.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_stastic.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        bt_stock.setFont(Font.loadFont("file:res/font/Tajawal-Light.ttf", 14));
        lb_titel.setFont(Font.loadFont("file:res/font/Cairo-Bold.ttf",24));
        lb_res.setFont(Font.loadFont("file:res/font/Tajawal-ExtraLight.ttf",14));

        Dimension screenSize = getDefaultToolkit().getScreenSize();
         width = screenSize.getWidth() ;
         height = screenSize.getHeight() ;


    }

    public void handleClicks(ActionEvent event) {
        if (event.getSource() == bt_users) {

            lb_res.setText("\\home\\job log");
  //          l_titel.setText("JOB LOG");
    //        pnlstatus.setBackground(new Background
      //              (new BackgroundFill
        //                    (Color.rgb(113, 86, 221), CornerRadii.EMPTY, Insets.EMPTY)));
          //  pn_joblog.toFront();
            refrensNodes(res_users);
            System.out.println("");
           // rootanchor.setLeftAnchor(patren,0.0);
            Dimension screenSize = getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth() ;
            double height = screenSize.getHeight() ;
            //patren.setPrefWidth(width);

           // System.out.println("ltft = 0");

            //rootanchor.setPrefWidth(1000.0);
           // patren.setPrefWidth(1000.0);

        }
        else if (event.getSource() == bt_fa_sell) {


            lb_res.setText("\\home\\customer");
            lb_titel.setText("CUSTOMER");
            pnlstatus1.setBackground(new Background
                    (new BackgroundFill
                            (Color.rgb(43, 99, 63), CornerRadii.EMPTY, Insets.EMPTY)));

            refrensNodes(res_customer);

        }
        else if (event.getSource() == bt_fa_buy) {


            lb_res.setText("الرئيسيه//الموردين");
            lb_titel.setText("tard");
            pnlstatus1.setBackground(new Background
                    (new BackgroundFill
                            (Color.rgb(99, 43, 63), CornerRadii.EMPTY, Insets.EMPTY)));
            refrensNodes(res_tard);

        }
        else if (event.getSource() == bt_castomer) {


            lb_res.setText("الرئيسيه / الزبائن/ ");
            lb_titel.setText("الزبائن");
            refrensNodes(res_customer);

        }

        else if (event.getSource() == bt_tard) {


            lb_res.setText("\\home\\tardes");
            lb_titel.setText("Tardes");

            refrensNodesfortardes(res_tard);

        }

        else if (event.getSource() == bt_stastic) {


            lb_res.setText("\\home\\driver");
            lb_titel.setText("DRIVER");

            refrensNodes(res_stastic);

        }
        else if (event.getSource() == bt_stock) {


            lb_res.setText("الرئيسسه/المخزون/");
            lb_titel.setText("المخزون");

            refrensNodes(res_stock);

        }


    }
    public void handleClose(MouseEvent event) {
        if (event.getSource() == bt_close1) {
            System.out.println("close donne");
            System.out.println("patren height : "+patren.getHeight());
            System.exit(0);
        }
    }

    private void refrensNodes(String fxml_layou) {
        patren.getChildren().clear();
        //Node nodes = new Node;
        try {
            // nodes = (Node) FXMLLoader.load(getClass().getResource("users.fxml"));
            AnchorPane df = FXMLLoader.load(getClass().getResource(fxml_layou));
            AnchorPane.setLeftAnchor(df, 0.0);
            AnchorPane.setBottomAnchor(df, 0.0);
            AnchorPane.setRightAnchor(df, 0.0);
            AnchorPane.setTopAnchor(df, 0.0);

            System.out.println(df.getPrefWidth()+" : is width of patren childe");
            patren.getChildren().add(df);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void refrensNodesfortardes(String fxml_layou) {
            patren.getChildren().clear();

            //Node nodes = new Node;

            try {
                /* µµµµµµµµµµµµ*/
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml_layou));
                Parent root = loader.load();

                TardesView tt = loader.getController();

                tt.setdata("الله أكبر");
               loader.setController(tt);
                AnchorPane df =new AnchorPane(root);
                AnchorPane.setLeftAnchor(df, 0.0);
                AnchorPane.setBottomAnchor(df, 0.0);
                AnchorPane.setRightAnchor(df, 0.0);
                AnchorPane.setTopAnchor(df, 0.0);
                df.setPrefWidth(width-180.0);

               // df.setPrefWidth(1000);
                patren.getChildren().add(df);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

