package layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author livejq
 * @since 2020/4/11
 **/
public class StackPaneDemo extends Application {
    /**
     * @info notes
     * GIF动画墙程序（StackPane中的控件类似图层的形式，前者可覆盖后者）
     **/
    ArrayList<Node> arrayNode = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        AnchorPane outSidePane = new AnchorPane();
        outSidePane.setPrefSize(700, 600);
//        outSidePane.setStyle("-fx-background-color: bisque");

        StackPane stackPane = new StackPane();
        ArrayList<BorderPane> gifList = getPic("/18so1.gif", "/18so2.gif", "/18so3.gif");
        stackPane.getChildren().addAll(gifList);

        Button previous = new Button("previous");
        Button next = new Button("Next");

        AnchorPane.setTopAnchor(stackPane, 0.0);
        AnchorPane.setLeftAnchor(stackPane, 0.0);
        AnchorPane.setRightAnchor(stackPane, 0.0);
        AnchorPane.setBottomAnchor(stackPane, 0.0);

        AnchorPane.setBottomAnchor(previous, 30.0);
        AnchorPane.setLeftAnchor(previous, 40.0);
        AnchorPane.setBottomAnchor(next, 30.0);
        AnchorPane.setRightAnchor(next, 40.0);

        previous.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (arrayNode.size() != 0) {
                    Node node = arrayNode.get(arrayNode.size() - 1);
                    stackPane.getChildren().add(node);
                    arrayNode.remove(arrayNode.size() - 1);
                    System.out.println("还剩 " + arrayNode.size() + " 个Node!");
                }
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (stackPane.getChildren().size() != 1) {
                    Node node = stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
                    arrayNode.add(node);
                }
            }
        });

        outSidePane.getChildren().addAll(stackPane, previous, next);
        Scene scene = new Scene(outSidePane);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("StackPane布局");
        primaryStage.show();
    }

    private static ArrayList<BorderPane> getPic(String... pictureName) {
        ArrayList<BorderPane> list  = new ArrayList<>();
        for (String name : pictureName) {
            BorderPane borderPane = new BorderPane();
            borderPane.setStyle("-fx-background-color: #43CD80");
            ImageView imageView = new ImageView(name);
//            imageView.setImage(new Image(name));
            borderPane.setCenter(imageView);

//            imageView.setFitWidth(400.0);
//            imageView.setFitHeight(340.0);
            list.add(borderPane);
        }

        return list;
    }
}
