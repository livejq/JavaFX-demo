package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/11
 **/
public class FlowPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) {

        Button button1 = new Button("按钮1");
        Button button2 = new Button("按钮2");
        Button button3 = new Button("按钮3");
        Button button4 = new Button("按钮4");
        Button button5 = new Button("按钮5");
        Button button6 = new Button("按钮6");
        Button button7 = new Button("按钮7");

        FlowPane flowPane = new FlowPane();
        flowPane.setStyle("-fx-background-color: #607B8B");
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setPadding(new Insets(20));
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setPrefWrapLength(100);
        flowPane.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7);


        Scene scene = new Scene(flowPane);
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);
        primaryStage.setTitle("BorderPane布局");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/favicon.png"));
        primaryStage.show();
    }
}
