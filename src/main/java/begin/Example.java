package begin;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/08
 **/
public class Example extends Application {

    private void initUI(Stage stage) {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setMaxWidth(900);
        stage.setMaxHeight(700);
        stage.setMinWidth(300);
        stage.setMinHeight(200);
//        stage.setResizable(true);
//        stage.setFullScreen(false);
//        stage.setIconified(false);
//        stage.setMaximized(true);

        stage.getIcons().add(new Image("/favicon.png"));
        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("高度：" + newValue.doubleValue());
        });
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("宽度" + newValue.doubleValue());
        });

//        Stage s2 = new Stage();
//        s2.setTitle("s2");
//        s2.initModality(Modality.APPLICATION_MODAL);
//        s2.toBack();
//        s2.show();
//        stage.initStyle(StageStyle.UNIFIED);

        Label welcome = new Label("欢迎来到JavaFX！");
        welcome.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 20));
//        welcome.setStyle("-fx-font-style: italic;");
        welcome.setAlignment(Pos.CENTER);
//        Group root = new Group(welcome);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.prefHeight(200);
        anchorPane.prefWidth(300);
        BackgroundFill bg1 = new BackgroundFill(Color.CYAN, new CornerRadii(10), new Insets(10));
        anchorPane.setBackground(new Background(bg1));
        anchorPane.getChildren().add(welcome);
        HBox hBox = new HBox(anchorPane);
        Scene s = new Scene(hBox);
        s.setFill(Color.WHITE);

        Screen screen = Screen.getPrimary();
        Rectangle2D rec1 = screen.getVisualBounds();
        System.out.println("dpi=" + screen.getDpi());
        System.out.println("width:" + rec1.getWidth() + ", height:" + rec1.getHeight());

        stage.setTitle("JavaFX");
        stage.setScene(s);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.runLater(() -> {
            System.out.println("runLater()-" + Thread.currentThread().getName());
            System.out.println(Platform.isSupported(ConditionalFeature.GRAPHICS));
            System.out.println(Platform.isSupported(ConditionalFeature.WEB));
            System.out.println(Platform.isSupported(ConditionalFeature.MEDIA));
            System.out.println(Platform.isSupported(ConditionalFeature.INPUT_METHOD));
            System.out.println(Platform.isSupported(ConditionalFeature.INPUT_MULTITOUCH));//false
            System.out.println(Platform.isSupported(ConditionalFeature.INPUT_POINTER));
            System.out.println(Platform.isSupported(ConditionalFeature.SHAPE_CLIP));
            System.out.println(Platform.isSupported(ConditionalFeature.VIRTUAL_KEYBOARD));//false
            System.out.println(Platform.isSupported(ConditionalFeature.SWING));
            System.out.println(Platform.isSupported(ConditionalFeature.UNIFIED_WINDOW));//false
            System.out.println(Platform.isSupported(ConditionalFeature.TRANSPARENT_WINDOW));
            System.out.println(Platform.isSupported(ConditionalFeature.SWT));//false
            System.out.println(Platform.isSupported(ConditionalFeature.TWO_LEVEL_FOCUS));//false

        });
        initUI(primaryStage);
//        Platform.exit();
        System.out.println("main.java.start()-" + Thread.currentThread().getName());
    }

    @Override
    public void init() {
        System.out.println("init()-" + Thread.currentThread().getName());
    }

    @Override
    public void stop() {
        System.out.println("stop()-" + Thread.currentThread().getName());
    }

}
