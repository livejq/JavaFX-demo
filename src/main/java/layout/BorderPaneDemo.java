package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/11
 **/
public class BorderPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) {


        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(600, 100);
        anchorPane1.setStyle("-fx-background-color: #EE1289");

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(100, 500);
        anchorPane2.setStyle("-fx-background-color: #CD6600");

        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setPrefSize(600, 100);
        anchorPane3.setStyle("-fx-background-color: #EE1289");

        AnchorPane anchorPane4 = new AnchorPane();
        anchorPane4.setPrefSize(100, 500);
        anchorPane4.setStyle("-fx-background-color: #CD6600");

        AnchorPane anchorPane5 = new AnchorPane();
        anchorPane5.setPrefSize(600, 100);
        anchorPane5.setStyle("-fx-background-color: #9B30FF");


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(anchorPane1);
        borderPane.setRight(anchorPane2);
        borderPane.setBottom(anchorPane3);
        borderPane.setLeft(anchorPane4);
        borderPane.setCenter(anchorPane5);


        Scene scene = new Scene(borderPane);
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);
        primaryStage.setTitle("BorderPane布局");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/favicon.png"));
        primaryStage.show();
    }
}
