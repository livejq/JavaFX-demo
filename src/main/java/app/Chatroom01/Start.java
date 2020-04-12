package app.Chatroom01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class Start extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(Start.this.getClass().getResource("fxml/01.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("app/Chatroom01/fxml/01.fxml"));
//        loader.setLocation(url);
//        System.out.println(url.toString());

//        System.out.println(TestFxml.class.getResource(""));
//        System.out.println(TestFxml.class.getResource("/"));
//        System.out.println();
//        System.out.println(TestFxml.class.getClassLoader().getResource(""));
//        System.out.println(TestFxml.class.getClassLoader().getResource("/"));

        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane);

        stage.setScene(scene);
        stage.setTitle("Chatroom01");
        stage.setResizable(false);
        stage.show();
    }

}
