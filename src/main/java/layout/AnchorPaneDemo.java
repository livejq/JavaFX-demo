package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AnchorPaneDemo extends Application {

    public static boolean isManaged = true;
    public static boolean isVisible = true;
    public static double isOpacity = 0.0;
    public static int count = 0;

    @Override
    public void start(Stage primaryStage) {

        Button button1 = new Button("按钮1");
        Button button2 = new Button("按钮2");
        Button button3 = new Button("按钮3");
        Button button4 = new Button("按钮4");

        button3.setOnAction(event -> {
            System.out.println("我被点击了第 " + ++count + " 次！");
        });

        Button button5 = new Button("按钮3:setManaged()");
        Button button6 = new Button("按钮3:setVisible()");
        Button button7 = new Button("按钮3:setOpacity()");

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #C5C1AA");
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        hBox.setPrefHeight(100);
        hBox.setPrefWidth(300);
        hBox.getChildren().addAll(button1, button2, button3, button4);

        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #607B8B");
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(150);
        vBox.setPrefWidth(200);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(button5, button6, button7);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #454545");

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);

        AnchorPane.setLeftAnchor(vBox, 100.0);
        AnchorPane.setBottomAnchor(vBox, 100.0);
        anchorPane.getChildren().addAll(hBox, vBox);

        button5.setOnAction(event -> {
            button3.setManaged(isManaged);
            if (isManaged) {
                isManaged = false;
                button5.setText("按钮3:setManaged(true)");
            } else {
                isManaged = true;
                button5.setText("按钮3:setManaged(false)");
            }
        });

        button6.setOnAction(event -> {
            button3.setVisible(isVisible);
            if (isVisible) {
                isVisible = false;
                button6.setText("按钮3:setVisible(true)");
            } else {
                isVisible = true;
                button6.setText("按钮3:setVisible(false)");
            }
        });

        button7.setOnAction(event -> {
            button3.setOpacity(isOpacity);
            if (isOpacity == 1.0) {
                isOpacity = 0.0;
                button7.setText("按钮3:setOpacity(1.0)");
            } else {
                isOpacity = 1.0;
                button7.setText("按钮3:setOpacity(0.0)");
            }
        });


        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/favicon.png"));
        primaryStage.setResizable(false);
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        primaryStage.setTitle("AnchorPane布局");
        primaryStage.show();
    }
}
