package control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Stastic implements Initializable {
@FXML
private  PieChart pieHash ,pieKey;
    @FXML
    private Label lblClose, lblExpired, lbl7, lbl30, lbl90,lblExp, lblActive;

    @FXML
    private Label lblOffline;

    @FXML
    private Circle shpActive;

    Random r = new Random();

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        Timeline tml = new Timeline();
        KeyFrame move = new KeyFrame(Duration.seconds(0.01),event -> {  loadHash(pieHash);tml.stop();});
        tml.getKeyFrames().add(move);
        tml.play();


        loadHash(pieHash);
       // loadHash(pieKey);
       // lblClose.setOnMouseClicked(e -> System.exit(0));

      /*  Timeline timeline = new Timeline(new KeyFrame(, event -> {
            loadHash(pieHash);
           // loadHash(pieKey);

            //shpActive.setFill(Color.LIMEGREEN);

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

          timeline.play();*/
           //timeline.stop();


        //shpActive.setFill(Color.WHITE);

    }
    private void loadHash(PieChart pieChart){
        ObservableList<PieChart.Data> data =
                FXCollections.observableArrayList(
                new PieChart.Data("Hash",40),
                        new PieChart.Data("Mash",60)
        );
        pieChart.setData(data);

    }

}
