package control;



import javafx.animation.Interpolator;
import javafx.animation.KeyValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.Toolkit.getDefaultToolkit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Dimension screenSize = getDefaultToolkit().getScreenSize();
         double width = screenSize.getWidth() ;
        double height = screenSize.getHeight() ;
        System.out.println(width+"  : good after  "+height+"");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        primaryStage.setTitle("sosalse");
        //primaryStage.initStyle(StageStyle.UNDECORATED); // اخفاء اطار النافذه
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.setFullScreen(true);  // تملئ الشاشه
        primaryStage.setResizable(false);  // تمنع تغيير ابعاد الشاشه

        primaryStage.show();
/*
        Catgory catgory  = new Catgory(1,"ملابس رجال داخليه","ملابس") ;
        Catgory catgoryu  = new Catgory(1,"ملابس رجال داخليه ت","ملابس ت") ;
        //DatabaseConnection db = new DatabaseConnection();
        //Connection con = db.connect();
        List<Catgory> list = new ArrayList<Catgory>();
        CatgoryDAOimplement catgoryDAOimplement = new CatgoryDAOimplement();
        //catgoryDAOimplement.saveCatgory(catgory);
        list = catgoryDAOimplement.getAllCatgory();
        System.out.println(list.get(0).getId() +"   "+list.get(0).getName()+"   "+list.get(0).getType() ); //
        catgoryDAOimplement.updateCatgory(catgory,1);
        Catgory catgorys  = new Catgory();
        catgorys = catgoryDAOimplement.getCatgoryById(1);
        System.out.println(catgorys.getId() +"   "+catgorys.getName()+"   "+catgorys.getType() ); //
        catgoryDAOimplement.deleteCatgory(1,true);
        catgoryDAOimplement.saveCatgory(catgory);*/

    }


    public static void main(String[] args) {


        Pattern p = Pattern.compile("a");

        // Matcher ثم قمنا بتخزينه في كائن نوعه aaaaaaaab على النص matcher() قمنا باستدعاء الدالة
        Matcher m = p.matcher("ali");

        // regex لمعرفة إذا تم إيجاد نص يطابق الـ Matcher على كائن الـ matches() قمنا باستدعاء الدالة
        System.out.println( "Result: " + m.matches() );



           launch(args);

    }
}


