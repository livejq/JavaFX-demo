package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/11
 **/
public class GridPaneDemo extends Application {
    /**
     * @info notes
     * 登录窗口
     **/
    public static int loginCount = 0;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #3B3B3B");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text loginTitle  = new Text("欢迎登录");
        loginTitle.setFill(Color.WHITE);
        loginTitle.setStyle("-fx-font-family: Tahoma;-fx-font-color: WHITE;-fx-font-size: 20");
        gridPane.add(loginTitle, 0, 0, 2, 1);

        Label userName = new Label("用户名：");
        userName.setTextFill(Color.WHITE);
        TextField userTextField = new TextField();
        userName.setLabelFor(userTextField);
        gridPane.add(userName, 0, 1);
        gridPane.add(userTextField, 1, 1);

        Label password = new Label("密码：");
        password.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        password.setLabelFor(passwordField);
        gridPane.add(password, 0, 2);
        gridPane.add(passwordField, 1, 2);

        Button loginButton = new Button("登录");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(loginButton);
        gridPane.add(hBox, 1, 4);

        final Text info = new Text();
        gridPane.add(info, 1, 6);

        loginButton.setOnAction(event -> {
            info.setFill(Color.YELLOW);
            info.setText("登录成功" + ++loginCount + "次！");
        });

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("GridPane布局");
        primaryStage.show();
    }
}
